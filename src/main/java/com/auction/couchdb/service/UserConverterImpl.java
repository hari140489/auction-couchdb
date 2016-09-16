package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.User;
import com.auction.couchdb.web.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by hsupar on 9/16/2016.
 */
@Component
public class UserConverterImpl implements UserConverter {

	@Override
	public User convert(final UserDto userDto) {
		final User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		return user;
	}
}
