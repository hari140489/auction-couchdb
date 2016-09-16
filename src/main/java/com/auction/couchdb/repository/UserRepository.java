package com.auction.couchdb.repository;

import com.auction.couchdb.repository.entity.User;

/**
 * Created by hsupar on 9/15/2016.
 */
public interface UserRepository {

    String save(User user);

    User findOne(String email);

}
