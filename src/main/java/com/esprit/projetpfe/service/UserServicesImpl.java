package com.esprit.projetpfe.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.esprit.projetpfe.entities.User;

import com.esprit.projetpfe.repository.UserRepository;

@Component
public class UserServicesImpl implements IUserServices {

	@Autowired
     UserRepository userrepository;
	


	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) userrepository.findAll();
	}

	@Override
	public void addUser(User user) {
		
		userrepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		
		userrepository.delete(user);
	}

	@Override

	public void updateUserById(String password, String id) {
		
		userrepository.updateUserById(password, id);
	}

	@Override
	public User theUser(String search) {
		
		
		System.out.println(userrepository.existsByUsermail(search));
		
		if(userrepository.findTheUserbyid(search) != null) {
			
			return userrepository.findTheUserbyid(search);
			
		}else if(userrepository.findTheUsebyusermail(search) != null)
		{
			return userrepository.findTheUsebyusermail(search);
		} 
		
		return null;
	}




	
	
}
