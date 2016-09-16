package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.User;
import com.auction.couchdb.generic.Converter;
import com.auction.couchdb.web.dto.UserDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface UserConverter extends Converter<UserDto, User> {

}
