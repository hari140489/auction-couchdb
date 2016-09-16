package com.auction.couchdb.service;

import com.auction.couchdb.generic.Converter;
import com.auction.couchdb.repository.entity.Auction;
import com.auction.couchdb.web.dto.AuctionDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface AuctionConverter extends Converter<AuctionDto, Auction>{

}
