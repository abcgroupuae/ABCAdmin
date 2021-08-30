package com.aisha.ABCAdmin.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aisha.ABCAdmin.Entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	public User findByResetPasswordToken(String token);
	
	User deleteById(int user_id);
	 
	Optional<User> findById(int user_id);
	

	List<User> findAllBystatus(int statusid);
	
	
	
}
