package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.Auction;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hsupar on 9/16/2016.
 */
@Repository
public class AuctionRepositoryImpl implements AuctionRepository{

	private static final Logger LOGGER = LoggerFactory.getLogger(
		AuctionRepositoryImpl.class);

	private final ObjectMapper couchDbObjectMapper;

	private final Bucket auctionBucket;

	@Autowired
	public AuctionRepositoryImpl(final ObjectMapper couchDbObjectMapper,
		final Bucket auctionBucket) {
		this.couchDbObjectMapper = couchDbObjectMapper;
		this.auctionBucket = auctionBucket;
	}

	@Override
	public String save(final Auction auction) {
		return null;
	}
}
