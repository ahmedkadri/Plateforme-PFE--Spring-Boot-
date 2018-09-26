package com.esprit.projetpfe;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;







@SpringBootApplication
public class ProjetPfeApplication {
	
	
	
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		//***************
	
	}
	
	private static Logger logger = LoggerFactory.getLogger(ProjetPfeApplication.class);
	

	public static void main(String[] args) {
	
		SpringApplication.run(ProjetPfeApplication.class, args);
		

		
		
		
		saveData();
		
	}
	
	public static void saveData() {
		
		
		

	}
	

}
