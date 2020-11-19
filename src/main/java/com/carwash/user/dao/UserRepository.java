package com.carwash.user.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUserId(String userId);

	User findByUserIdAndPassword(String userId, String password);
	
	List<User> findByRole(String washer);
	
	List<User> findByRoleAndIsActiveIsTrue(String washer);

}
