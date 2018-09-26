package com.esprit.projetpfe.payload;

import org.hibernate.validator.constraints.NotBlank;

public class Userfind {

	@NotBlank
    private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
