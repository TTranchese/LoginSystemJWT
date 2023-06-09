package com.example.LoginSystemJWT.auth;

import com.example.LoginSystemJWT.config.JwtService;
import com.example.LoginSystemJWT.user.Role;
import com.example.LoginSystemJWT.user.User;
import com.example.LoginSystemJWT.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = new User.Builder()
				.setFirstName(request.getFirstName())
				.setLastName(request.getLastName())
				.setEmail(request.getEmail())
				.setPassword(encoder.encode(request.getPassword()))
				.setRole(Role.USER)
				.build();
		var jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse.Builder()
				.setToken(jwtToken)
				.build();
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
				)
		);
		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse.Builder()
				.setToken(jwtToken)
				.build();
	}
}
