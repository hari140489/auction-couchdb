package com.auction.couchdb.service;

import com.auction.couchdb.web.dto.BidDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface BiddingService {

	void createBid(BidDto bidDto);
}
