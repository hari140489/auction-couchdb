package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.Bid;
import com.auction.couchdb.util.DateUtilities;
import com.auction.couchdb.web.dto.BidDto;
import org.springframework.stereotype.Component;

/**
 * Created by hsupar on 9/16/2016.
 */
@Component
public class BidConverterImpl implements BidConverter {

	@Override
	public Bid convert(final BidDto bidDto) {
		final Bid bid = new Bid();
		bid.setProductId(bidDto.getProductId());
		bid.setStartAmount(bidDto.getStartAmount());
		bid.setStartDate(DateUtilities.toDate(bidDto.getStartDate()));
		bid.setEndDate(DateUtilities.toDate(bidDto.getEndDate()));
		return bid;
	}
}
