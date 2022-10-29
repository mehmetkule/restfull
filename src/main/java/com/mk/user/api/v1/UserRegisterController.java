package com.mk.user.api.v1;

import com.mk.user.api.dto.UserRequest;
import com.mk.user.api.dto.UserResponse;
import com.mk.user.exception.BadRequestException;
import com.mk.user.exception.DublicateUserException;
import com.mk.user.exception.UserNotFoundException;
import com.mk.user.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mk/v1")
public class UserRegisterController {
	private final UserRegistrationService userRegistrationService;

	public UserRegisterController(UserRegistrationService userRegistrationService ) {
		this.userRegistrationService = userRegistrationService;

	}

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponse create(@RequestBody UserRequest request)throws BadRequestException, DublicateUserException,UserNotFoundException{
		return userRegistrationService.createUser(request);
	}


	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public UserResponse getUser(@PathVariable("id")UUID id) throws UserNotFoundException{
		return userRegistrationService.getUser(id);
	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<UserResponse> getUsers(){
		return userRegistrationService.getUsers();
	}

}
