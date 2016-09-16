package com.auction.couchdb.service;

import com.auction.couchdb.web.dto.UserDto;

/**
 * Created by hsupar on 9/15/2016.
 */
public interface UserService {

	void save(UserDto user);

	UserDto getUser(String email);
}
