package com.esprit.projetpfe.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.esprit.projetpfe.security.UserPrincipal;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

	 	@Bean
	    public AuditorAware<String> auditorProvider() {

	        return new SpringSecurityAuditAwareImpl();

	    }
}

class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null ||

                !authentication.isAuthenticated() ||

                authentication instanceof AnonymousAuthenticationToken) {

            return null;
        }
		
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		return userPrincipal.getId();
	}
	
	
}