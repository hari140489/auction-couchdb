package com.auction.couchdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by hsupar on 9/16/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BiddingServiceImplIntegrationTest {

	@Autowired
	private BiddingService biddingService;

	@Test
	public void testCreateBid() {
		// TODO: 9/16/2016
	}

}