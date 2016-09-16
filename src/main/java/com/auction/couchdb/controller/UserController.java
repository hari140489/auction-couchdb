package com.auction.couchdb.controller;

import com.auction.couchdb.service.UserService;
import com.auction.couchdb.web.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hsupar on 9/16/2016.
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		UserController.class);

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody final UserDto userDto) {
		LOGGER.debug("Started saving user {}", userDto);
		userService.save(userDto);
		LOGGER.debug("Finished saving user {}", userDto);
	}

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUser(@PathVariable final String email) {
		LOGGER.debug("Fetching user with input email {}", email);
		final UserDto userDto = userService.getUser(email);
		LOGGER.debug("Finished fetching user {} with email {}", userDto);
		return userDto;
	}
}
