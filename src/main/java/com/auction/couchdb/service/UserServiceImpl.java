package com.auction.couchdb.service;

import com.auction.couchdb.exception.AuctionException;
import com.auction.couchdb.exception.DoesNotExistException;
import com.auction.couchdb.repository.entity.User;
import com.auction.couchdb.repository.UserRepository;
import com.auction.couchdb.web.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by hsupar on 9/15/2016.
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		UserServiceImpl.class);

	private final PasswordEncoder encoder;

	private final UserConverter userConverter;

	private final UserRepository userRepository;

	private final UserDtoConverter userDtoConverter;

	@Autowired
	public UserServiceImpl(final PasswordEncoder encoder,
		final UserConverter userConverter, UserRepository userRepository,
		final UserDtoConverter userDtoConverter) {
		this.encoder = encoder;
		this.userConverter = userConverter;
		this.userRepository = userRepository;
		this.userDtoConverter = userDtoConverter;
	}

	@Override
	public void save(UserDto userDto) {
		LOGGER.debug("Saving user {} in service", userDto);
		if (userDto == null) {
			throw new AuctionException("Input for saving user is null");
		}
		userDto.setPassword(encoder.encode(userDto.getPassword()));
		final User user = userConverter.convert(userDto);
		String id = userRepository.save(user);
		LOGGER.debug(
			"Finished saving user {} in service and the generated id is {}",
			userDto, id);
	}

	@Override
	public UserDto getUser(final String email) {
		LOGGER.debug("Fetching user details for input email {} in service",
			email);
		final User user = userRepository.findOne(email);
		if (user != null) {
			final UserDto userDto = userDtoConverter.convert(user);
			LOGGER.debug(
				"Fetching fetching user details {} for input email {} in service",
				userDto, email);
			return userDto;
		}
		else {
			throw new DoesNotExistException(
				"User details doesn't exist with input email " + email);
		}
	}
}
