package com.esprit.projetpfe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.projetpfe.entities.User;
import com.esprit.projetpfe.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		
		User user = userRepository.findByFirstnameOrUsermail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
		return UserPrincipal.create(user);
	}

	
	
}
