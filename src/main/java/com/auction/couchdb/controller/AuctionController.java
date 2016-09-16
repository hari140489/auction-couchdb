package com.auction.couchdb.controller;

import com.auction.couchdb.service.AuctionService;
import com.auction.couchdb.web.dto.AuctionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hsupar on 9/16/2016.
 */
@RestController
public class AuctionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		AuctionController.class);

	private final AuctionService auctionService;

	public AuctionController(final AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping(value = "/auction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createAuction(@RequestBody final AuctionDto auctionDto) {
		LOGGER.debug("Creating auction {}", auctionDto);
		auctionService.save(auctionDto);
		LOGGER.debug("Created auction {}", auctionDto);
	}
}
