package com.example.LoginSystemJWT.config;

import com.example.LoginSystemJWT.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	
	private UserRepository userRepository;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}
	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		
	}
}
