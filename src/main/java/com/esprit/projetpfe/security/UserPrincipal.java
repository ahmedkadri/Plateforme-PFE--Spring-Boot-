package com.esprit.projetpfe.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.esprit.projetpfe.entities.User;

public class UserPrincipal implements UserDetails {

	private String id;
	
	private String firstname;
	
	private String lastname;
	
	private String usermail;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	
	
	
	
	public UserPrincipal() {
		super();
	}

	public UserPrincipal(String id, String firstname, String lastname, String usermail, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.usermail = usermail;
		this.password = password;
		this.authorities = authorities;
	}

	 public static UserPrincipal create(User user) {

	        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->

	                new SimpleGrantedAuthority(role.getName().name())

	        ).collect(Collectors.toList());
	
	        return new UserPrincipal(
	        		user.getUserid(),
	        		user.getFirstname(),
	        		user.getLastname(),
	        		user.getUsermail(),
	        		user.getPassword(),
	        		authorities
	        		);
	 }
	 
	 
	 
	 
	 
	 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return usermail;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
