package com.esprit.projetpfe.service;

import java.util.List;

import com.esprit.projetpfe.entities.User;

public interface IUserServices {

	public List<User> getAllUsers();
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUserById(String password, String id);
	public User theUser(String search);

}
