package com.esprit.projetpfe.payload;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignUpRequest {

	@NotBlank
	private String userid;
	
	@NotBlank
    @Size(max = 40)
	private String firstname;
	
	@NotBlank
    @Size(max = 15)
	private String lastname;
	
	
	@NotBlank
    @Size(max = 40)
	@Email
	private String usermail;
	
	@NotBlank
    @Size(max = 100)
	private String password;

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
