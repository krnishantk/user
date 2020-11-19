package com.carwash.user.resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.user.model.LoginRequest;
import com.carwash.user.model.RestResponse;
import com.carwash.user.model.User;
import com.carwash.user.service.UserService;

@RequestMapping("user")
@RestController
@CrossOrigin
public class UserResource {

	@Autowired
	private UserService userService;

	@PostMapping("login")
	public RestResponse checkLogin(@RequestBody LoginRequest loginRequest) {
		RestResponse response = new RestResponse();
		HashMap<String, Object> responseMap = new HashMap<>();
		if (loginRequest.getUserId().equals("") || loginRequest.getPassword().equals("")) {
			response.setMsg("userId or password cannot be empty");
			return response;
		}
		User isUser = userService.isUserByUserId(loginRequest.getUserId());
		if (isUser != null) {
			User user = userService.getUserByUserIdAndPassword(loginRequest.getUserId(), loginRequest.getPassword());
			if (user != null) {
				responseMap.put("userId", user.getUserId());
				responseMap.put("role", user.getRole());
				response.setData(responseMap);
				response.setMsg("Login Successfully");
				return response;
			} else {
				response.setMsg("Please enter correct userid and password");
				return response;
			}
		} else {
			responseMap.put("userId", loginRequest.getUserId());
			response.setData(responseMap);
			response.setMsg("Please enter correct userid and password");
			return response;
		}
	}

	@PostMapping()
	public RestResponse addUser(@RequestBody User user) {
		RestResponse response = new RestResponse();
		User isUser = userService.isUserByUserId(user.getUserId());
		if (isUser == null) {
			User newUser = userService.saveUser(user);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("userId", newUser.getUserId());
			response.setData(responseMap);
			response.setMsg("new user added successfully");

		} else {
			response.setMsg("user id already exist");
		}
		return response;
	}

	@GetMapping("{userId}")
	public RestResponse getUser(@PathVariable String userId) {
		RestResponse response = new RestResponse();
		User isUser = userService.isUserByUserId(userId);
		if (isUser != null) {
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("userId", isUser);
			response.setData(responseMap);
			response.setMsg("user information fetch Successfully");

		} else {
			response.setMsg("user id doesn't exist");
		}
		return response;
	}

	@PutMapping()
	public RestResponse updateUser(@RequestBody User user) {
		RestResponse response = new RestResponse();
		User isUser = userService.isUserByUserId(user.getUserId());
		if (isUser != null) {
			isUser.setCity(user.getCity());
			isUser.setEmail(user.getEmail());
			isUser.setFirstName(user.getFirstName());
			isUser.setLastName(user.getLastName());
			isUser.setPhone(user.getPhone());
			userService.saveUser(isUser);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("userId", isUser);
			response.setData(responseMap);
			response.setMsg("user information updated Successfully");

		} else {
			response.setMsg("user id doesn't exist");
		}
		return response;
	}

	@DeleteMapping("{userId}")
	public RestResponse deleteUser(@PathVariable String userId) {
		RestResponse response = new RestResponse();
		User isUser = userService.isUserByUserId(userId);
		if (isUser != null) {
			userService.deleteUser(isUser);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("userId", isUser.getUserId());
			response.setData(responseMap);
			response.setMsg("user deleted Successfully");

		} else {
			response.setMsg("user id doesn't exist");
		}
		return response;
	}

	@GetMapping("getCarWasher")
	public List<User> getAllCarWasher() {
		RestResponse response = new RestResponse();
		List<User> carWasher = userService.getAllCarWasher();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("userId", carWasher);
		response.setData(responseMap);
		response.setMsg("get all car washer information Successfully");

		return carWasher;
	}

	@GetMapping("getActiveCarWasher")
	public List<User> getActiveCarWasher() {
		RestResponse response = new RestResponse();
		List<User> carWasher = userService.getActiveCarWasher();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("userId", carWasher);
		response.setData(responseMap);
		response.setMsg("get all active car washer information Successfully");

		return carWasher;
	}

	@GetMapping("getCustomer")
	public List<User> getAllCustomer() {
		RestResponse response = new RestResponse();
		List<User> carWasher = userService.getAllCustomer();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("userId", carWasher);
		response.setData(responseMap);
		response.setMsg("get all customer information Successfully");

		return carWasher;
	}

	@PutMapping("activeInActive/{userId}")
	public RestResponse getActiveInActive(@PathVariable String userId) {
		RestResponse response = new RestResponse();
		User isUser = userService.isUserByUserId(userId);
		if (isUser != null) {
			if (isUser.getIsActive()) {
				isUser.setIsActive(false);
				userService.changeMode(isUser);
				response.setMsg("user is in inActive mode");
			} else {
				isUser.setIsActive(true);
				userService.changeMode(isUser);
				response.setMsg("user is in active mode");
			}
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("userId", isUser.getUserId());
			response.setData(responseMap);
		} else {
			response.setMsg("user id doesn't exist");
		}
		return response;
	}

}
