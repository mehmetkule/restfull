package com.mk.user.service;

import com.mk.user.api.dto.UserRequest;
import com.mk.user.api.dto.UserResponse;
import com.mk.user.db.User;
import com.mk.user.db.UserRepository;
import com.mk.user.exception.BadRequestException;
import com.mk.user.exception.DublicateUserException;
import com.mk.user.exception.UserNotFoundException;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(rollbackFor = {UserNotFoundException.class,DublicateUserException.class,RuntimeException.class})
public class UserRegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);

	private UserRepository userRepository;
	@Autowired
	public UserRegistrationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserResponse createUser(UserRequest request)throws DublicateUserException,UserNotFoundException, BadRequestException {
		if (request.getEmail() == null){
			throw new BadRequestException("Email not null");
		}
		logger.info("Creating a new User" + request.getEmail() + "first:" + request.getFirstName() + "last:" + request.getLastName());
		Optional<User> userOptional = userRepository.findUserByEmail(request.getEmail());
		if (userOptional.isPresent()){
			throw  new DublicateUserException("Duplicate user with email:" + request.getEmail());
		}

		User user = new User(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword());
		user = userRepository.save(user);
		return  new UserResponse(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());

	}

	public User findUser(UUID id) throws UserNotFoundException {
		logger.info("Fetching for user" + id);
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			throw new UserNotFoundException("User ID:" + id + "not found");
		}
		return userOptional.get();
	}

	public UserResponse getUser(UUID id) throws UserNotFoundException {
		logger.info("Fetching for user" + id);
		User user = findUser(id);
		return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}

	public List<UserResponse> getUsers(){
		List<UserResponse> users = new ArrayList<>();
		userRepository.findAll().forEach(user->{
			users.add(new UserResponse(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail()));
		});
		return users;
	}
}
