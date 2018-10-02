package com.esprit.projetpfe.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.esprit.projetpfe.security.CustomUserDetailsService;
import com.esprit.projetpfe.security.JwtAuthenticationEntryPoint;
import com.esprit.projetpfe.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    CustomUserDetailsService customUserDetailsService;
	
	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	
	@Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

		authenticationManagerBuilder
        .userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder());
	}
	
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	
	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
         .cors()
             .and()
         .csrf()
             .disable()
         .exceptionHandling()
             .authenticationEntryPoint(unauthorizedHandler)
             .and()
         .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
         .authorizeRequests()
             .antMatchers("/",
                 "/favicon.ico",
                 "/**/*.png",
                 "/**/*.gif",
                 "/**/*.svg",
                 "/**/*.jpg",
                 "/**/*.html",
                 "/**/*.css",
                 "/**/*.js")
                 .permitAll()
             .antMatchers("/user/**")
                 .permitAll()
             .antMatchers("/convention/**")
                 .permitAll()
             .antMatchers("/entreprise/**")
                 .permitAll()
             .antMatchers("/fiche/**")
                 .permitAll()
             .antMatchers("/technologie/**")
                 .permitAll()
             .antMatchers(HttpMethod.GET, "/user/allusers", "/user/me")
                 .permitAll()
             .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**")
                 .permitAll()
             .anyRequest()
                 .authenticated();

		 // Add our custom JWT security filter
		 http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	
	}
	

}
