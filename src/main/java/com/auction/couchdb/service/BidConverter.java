package com.auction.couchdb.service;

import com.auction.couchdb.generic.Converter;
import com.auction.couchdb.repository.entity.Bid;
import com.auction.couchdb.web.dto.BidDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface BidConverter extends Converter<BidDto, Bid> {


}
