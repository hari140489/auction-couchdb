package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.Auction;
import com.auction.couchdb.web.dto.AuctionDto;
import org.springframework.stereotype.Component;

/**
 * Created by hsupar on 9/16/2016.
 */
@Component
public class AuctionConverterImpl implements AuctionConverter {

	@Override
	public Auction convert(final AuctionDto auctionDto) {
		final Auction auction = new Auction();
		auction.setBidId(auctionDto.getBidId());
		auction.setAmount(auctionDto.getAmount());
		auction.setEmail(auctionDto.getEmail());
		return auction;
	}
}
