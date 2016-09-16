package com.auction.couchdb.repository;

import com.auction.couchdb.repository.entity.User;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hsupar on 9/15/2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	private final Bucket userBucket;

	private final ObjectMapper couchBaseDbObjectMapper;

	@Autowired
	public UserRepositoryImpl(Bucket userBucket,
		final ObjectMapper couchBaseDbObjectMapper) {
		this.userBucket = userBucket;
		this.couchBaseDbObjectMapper = couchBaseDbObjectMapper;
	}

	@Override
	public String save(User user) {
		try {
			final String userJson = couchBaseDbObjectMapper.writeValueAsString(
				user);
			final String email = user.getEmail();
			userBucket.insert(
				JsonDocument.create(email, JsonObject.fromJson(userJson)));
			return email;
		}
		catch (JsonProcessingException e) {
			throw new RuntimeException("Unable to save user " + user, e);
		}
	}

	@Override
	public User findOne(final String email) {
		return null;
	}
}
