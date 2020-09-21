package com.eureka.user.controllers;

import com.eureka.user.entities.User;
import com.eureka.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private Environment env;

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of user service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from User Service running at port: " + env.getProperty("local.server.port");
	}

	@PostMapping(path ="/api/user")
	public ResponseEntity<User> register(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}
}
