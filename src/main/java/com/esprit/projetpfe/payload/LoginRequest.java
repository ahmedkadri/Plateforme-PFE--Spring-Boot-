package com.esprit.projetpfe.payload;

import org.hibernate.validator.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
    private String usermail;

    @NotBlank
    private String password;
    
    

	

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
