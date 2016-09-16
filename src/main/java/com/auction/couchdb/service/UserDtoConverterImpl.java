package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.User;
import com.auction.couchdb.web.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by hsupar on 9/16/2016.
 */
@Component
public class UserDtoConverterImpl implements UserDtoConverter {

	@Override
	public UserDto convert(final User user) {
		return null;
	}
}
