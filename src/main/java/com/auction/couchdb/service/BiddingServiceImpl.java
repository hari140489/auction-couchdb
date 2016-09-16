package com.auction.couchdb.service;

import com.auction.couchdb.exception.AuctionException;
import com.auction.couchdb.exception.DoesNotExistException;
import com.auction.couchdb.repository.BiddingRepository;
import com.auction.couchdb.repository.ProductRepository;
import com.auction.couchdb.repository.entity.Bid;
import com.auction.couchdb.repository.entity.Product;
import com.auction.couchdb.web.dto.BidDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hsupar on 9/16/2016.
 */
@Service
public class BiddingServiceImpl implements BiddingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		BiddingServiceImpl.class);

	private final ProductRepository productRepository;

	private final BidConverter bidConverter;

	private final BiddingRepository biddingRepository;

	@Autowired
	public BiddingServiceImpl(final ProductRepository productRepository,
		final BidConverter bidConverter,
		final BiddingRepository biddingRepository) {
		this.productRepository = productRepository;
		this.bidConverter = bidConverter;
		this.biddingRepository = biddingRepository;
	}

	@Override
	public void createBid(final BidDto bidDto) {
		LOGGER.debug("Started saving bid {}", bidDto);
		if (bidDto == null) {
			throw new AuctionException("Input for creation of bid is null");
		}
		final String productId = bidDto.getProductId();
		final Product product = productRepository.findOne(productId);
		if (product == null) {
			throw new DoesNotExistException(
				"Product doesn't exist with id " + productId);
		}
		final Bid bid = bidConverter.convert(bidDto);
		String id = biddingRepository.save(bid);
		LOGGER.debug("Saved input bid {} with id {}", bidDto, id);
	}
}
