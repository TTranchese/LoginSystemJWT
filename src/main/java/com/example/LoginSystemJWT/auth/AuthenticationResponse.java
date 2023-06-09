package com.example.LoginSystemJWT.auth;

public class AuthenticationResponse {
	private String token;
	
	public AuthenticationResponse(String token) {
		this.token = token;
	}
	
	public AuthenticationResponse() {
	}
	
	public AuthenticationResponse(builder builder) {
		this.token = builder.token;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public static class builder {
		private String token;
		
		public builder setToken(String token) {
			this.token = token;
			return this;
		}
		
		public AuthenticationResponse build() {
			return new AuthenticationResponse(this);
		}
	}
	
}
