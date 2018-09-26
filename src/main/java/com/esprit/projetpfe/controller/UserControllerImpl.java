package com.esprit.projetpfe.controller;



import java.util.Collections;
import java.util.List;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.esprit.projetpfe.entities.Role;
import com.esprit.projetpfe.entities.RoleName;
import com.esprit.projetpfe.entities.User;
import com.esprit.projetpfe.payload.JwtAuthenticationResponse;
import com.esprit.projetpfe.payload.LoginRequest;
import com.esprit.projetpfe.payload.SignUpRequest;
import com.esprit.projetpfe.payload.UserSummary;
import com.esprit.projetpfe.payload.Userfind;
import com.esprit.projetpfe.repository.RoleRepository;
import com.esprit.projetpfe.repository.UserRepository;

import com.esprit.projetpfe.security.JwtTokenProvider;

import com.esprit.projetpfe.service.UserServicesImpl;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;



@RestController
@RequestMapping(path="/user")
public class UserControllerImpl {

	@Autowired
	public UserServicesImpl userservice;
	
	@Autowired
	public UserRepository userrepo;
	
	@Autowired
	public RoleRepository roleRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public JwtTokenProvider tokenProvider;
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	User testu ;
	
	private String email ;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // A faire pour toute les classes
	
 	@RequestMapping(value = "/me",method = RequestMethod.GET,headers = {"Accept=application/json"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getConnectedUser(){
		
 		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-");
 		
		System.out.println(this.getEmail());
		
		testu = userservice.theUser(this.getEmail());
		
		System.out.println(testu.getUserid());
		
		return  new ResponseEntity<>(testu,HttpStatus.OK);
	}

	
	
	
	@RequestMapping(value = "/allusers",method = RequestMethod.GET,headers = {"Accept=application/json"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {
		
		System.out.println("**************");
		
		logger.debug("Invocation de la resource : GET /all users");
		
		List<User> listuser = userservice.getAllUsers();
		
		
		if(listuser == null) {
			logger.info("Impossible de récupérer users");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return  new ResponseEntity<>(listuser,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/finduser",method = RequestMethod.POST,headers = {"Accept=application/json"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getOneUsers(@RequestBody Userfind search) {
		
		System.out.println("********"+search+"********");
		System.out.println("**************");
		logger.debug("Invocation de la resource : GET /User");
		
		if(userservice.theUser(search.getSearch())== null) {
			System.out.println("Not Fount");
			logger.info("Impossible de récupérer users");
		}
	
		
		System.out.println("found"+search);
		return  new ResponseEntity<>(userservice.theUser(search.getSearch()),HttpStatus.OK);
	}

	@RequestMapping(value="/delete/{userId}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userid)
	{
		logger.debug("Invocation de la resource : DELETE /User/");
		
		userservice.deleteUser(new User(userid));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
	@RequestMapping(value="/update/{userId}",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateUser(@PathVariable("userId") String userid, @RequestBody User user)
	{
		System.out.println(user.getPassword());
		logger.debug("Invocation de la resource : PUT /user/");
		String passx = passwordEncoder.encode(user.getPassword());
		
		
		userservice.updateUserById(passx, userid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		
		if(userrepo.existsByUsermail(signUpRequest.getUsermail())) {
			
			throw new RuntimeException("User Mail already exist");
		}
		
		User user = new User(signUpRequest.getUserid(),
							 signUpRequest.getFirstname(),
							 signUpRequest.getLastname(),
							 signUpRequest.getUsermail(),
							 signUpRequest.getPassword()
							 );
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Role userRole = roleRepository.findByName(RoleName.ROLE_ETUDIANT);
		
		user.setRoles(Collections.singleton(userRole));
		
		User result = userrepo.save(user);
		
		URI location = ServletUriComponentsBuilder

                .fromCurrentContextPath().path("/users/{username}")

                .buildAndExpand(result.getUserid()).toUri();
		
		return ResponseEntity.created(location).body("User registered successfully");
	}

	 @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		
		
		System.out.println("fatma lfalouma");
		System.out.println("***************************");
		System.out.println(loginRequest.getUsermail());
		System.out.println("***************************");
		System.out.println(loginRequest.getPassword());
		
		this.email = loginRequest.getUsermail();
		
		Authentication authentication = authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                		loginRequest.getUsermail(),
                		loginRequest.getPassword()
                		)
                );
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//************************
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		System.out.println(authentication.isAuthenticated());
		System.out.println(authentication.getName());
		System.out.println(authentication.getAuthorities());
		//*****************************************
		String jwt = tokenProvider.generateToken(authentication);
		
		System.out.println(jwt);
		
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
		
	}
	 
	 
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @RequestMapping(value = "/update/admin", method = RequestMethod.POST, consumes="application/json")
	 public ResponseEntity<Void> UpdateUsersByAdmin(@RequestBody User user){
 
		 userservice.addUser(user);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
}
