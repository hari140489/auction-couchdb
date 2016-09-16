package com.auction.couchdb.config;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonInclude;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by hsupar on 9/16/2016.
 */
@Configuration
public class AuctionConfig {

	@Bean
	public ObjectMapper couchBaseDbObjectMapper() {
		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
