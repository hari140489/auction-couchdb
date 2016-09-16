package com.auction.couchdb.service;

import com.auction.couchdb.web.dto.AuctionDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface AuctionService {

	void save(AuctionDto auctionDto);
}
