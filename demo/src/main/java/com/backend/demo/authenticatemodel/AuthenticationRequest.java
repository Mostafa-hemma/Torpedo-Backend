package com.backend.demo.authenticatemodel;

public class AuthenticationRequest {
	
	    private String phoneNumber;
	    private String password;
	    
	    private AuthenticationRequest() {}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPnoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    
}


