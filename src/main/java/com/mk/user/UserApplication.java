package com.mk.user;

import com.mk.user.db.UserRepository;
import com.mk.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mk.user.db")
@ComponentScan(basePackageClasses = UserRegistrationService.class)
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
