package com.auction.couchdb.controller;

import com.auction.couchdb.service.BiddingService;
import com.auction.couchdb.web.dto.BidDto;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiddingController {

	private final BiddingService biddingService;

	@Autowired
	public BiddingController(final BiddingService biddingService) {
		this.biddingService = biddingService;
	}

	@RequestMapping(value = "/bid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createBid(@RequestBody final BidDto bidDto) {
		biddingService.createBid(bidDto);
	}
}
