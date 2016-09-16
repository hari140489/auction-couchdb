package com.auction.couchdb.repository;

import com.auction.couchdb.repository.entity.Bid;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by hsupar on 9/16/2016.
 */
@Repository
public class BiddingRepositoryImpl implements BiddingRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		BiddingRepositoryImpl.class);

	private final ObjectMapper couchBaseDbObjectMapper;

	private final Bucket bidBucket;

	@Autowired
	public BiddingRepositoryImpl(final ObjectMapper couchBaseDbObjectMapper,
		final Bucket bidBucket) {
		this.couchBaseDbObjectMapper = couchBaseDbObjectMapper;
		this.bidBucket = bidBucket;
	}

	@Override
	public String save(final Bid bid) {
		LOGGER.debug("Saving bid in repository {}", bid);
		try {
			final String bidJson = couchBaseDbObjectMapper.writeValueAsString(
				bid);
			final String id = UUID.randomUUID().toString();
			bid.setId(id);
			bidBucket.insert(
				JsonDocument.create(id, JsonObject.fromJson(bidJson)));
			LOGGER.debug("Finished saving bid in repository {}", bid);
			return id;
		}
		catch (JsonProcessingException e) {
			throw new RuntimeException("Unable to save bid " + bid, e);
		}
	}
}
