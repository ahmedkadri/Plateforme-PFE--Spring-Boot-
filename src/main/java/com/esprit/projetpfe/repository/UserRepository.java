package com.esprit.projetpfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.esprit.projetpfe.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,String > {

	//@Query("update User u set u.firstname = ?1, u.lastname = ?2, u.password = ?3 where u.userid = ?4")
	
	@Transactional
    @Modifying
	@Query("update User u set  u.password = ?1 where u.userid = ?2")
	void updateUserById( String password,String userid);
	
	
	User findByUseridAndPassword(String userid, String password);
	
	Optional<User> findByFirstnameOrUsermail(String username, String email);


	@Query("select u from User u where u.userid =:search")
	User findTheUserbyid(@Param(value = "search")String userid);
	

	@Query("select u from User u where u.usermail like %?1")
    public User findTheUsebyusermail(String usermail); 
	
	//@Query("select u from User u where u.userid =:search or u.usermail =:search")
	//User findByUsermailOrUserid(@Param(value = "search")String search);
	
	//*****************
	Optional<User> findByUserid(String id);
	
	boolean existsByUsermail(String usermail);
	boolean existsByUserid(String userid);
}
