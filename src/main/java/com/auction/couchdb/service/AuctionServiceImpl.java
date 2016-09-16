package com.auction.couchdb.service;

import com.auction.couchdb.constant.Status;
import com.auction.couchdb.exception.AuctionException;
import com.auction.couchdb.repository.entity.Auction;
import com.auction.couchdb.web.dto.AuctionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hsupar on 9/16/2016.
 */
@Service
public class AuctionServiceImpl implements AuctionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		AuctionServiceImpl.class);

	private final AuctionConverter auctionConverter;

	private final AuctionRepository auctionRepository;

	@Autowired
	public AuctionServiceImpl(final AuctionConverter auctionConverter,
		final AuctionRepository auctionRepository) {
		this.auctionConverter = auctionConverter;
		this.auctionRepository = auctionRepository;
	}

	@Override
	public void save(final AuctionDto auctionDto) {
		LOGGER.debug("Saving auction {}", auctionDto);
		if (auctionDto == null) {
			throw new AuctionException("Input for saving auction is null");
		}
		final Auction auction = auctionConverter.convert(auctionDto);
		auction.setStatus(Status.PENDING.toString());
		final String id = auctionRepository.save(auction);
		LOGGER.debug("Saved auction {} with id {}", auction, id);
	}
}
