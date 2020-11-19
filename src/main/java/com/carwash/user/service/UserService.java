package com.carwash.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.user.dao.UserRepository;
import com.carwash.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User isUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	public User saveUser(User user) {
		user.setIsActive(true);
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public User getUserByUserIdAndPassword(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
	}

	public List<User> getAllCarWasher() {
		return userRepository.findByRole("Washer");
	}

	public List<User> getActiveCarWasher() {
		return userRepository.findByRoleAndIsActiveIsTrue("Washer");
	}

	public List<User> getAllCustomer() {
		return userRepository.findByRole("Customer");
	}

	public User changeMode(User user) {
		return userRepository.save(user);
	}

}
