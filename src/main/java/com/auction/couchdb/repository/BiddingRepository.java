package com.auction.couchdb.repository;

import com.auction.couchdb.repository.entity.Bid;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface BiddingRepository {

	String save(Bid bid);
}
