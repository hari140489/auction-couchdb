package com.auction.couchdb.controller;

import com.auction.couchdb.service.ProductService;
import com.auction.couchdb.web.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		ProductController.class);

	private final ProductService productService;

	@Autowired
	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody final ProductDto productDto) {
		LOGGER.debug("Received request for creating product {}", productDto);
		productService.save(productDto);
		LOGGER.debug("Processed request and created document {}", productDto);
	}
}
