package com.example.LoginSystemJWT.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(
			@NotNull HttpServletRequest request,
			@NotNull HttpServletResponse response,
			@NotNull FilterChain filterChain
	) throws ServletException, IOException {
		final String authHeader= request.getHeader("Authorization");
	}
}
