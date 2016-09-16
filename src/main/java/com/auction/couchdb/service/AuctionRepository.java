package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.Auction;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface AuctionRepository {

	String save(Auction auction);
}
