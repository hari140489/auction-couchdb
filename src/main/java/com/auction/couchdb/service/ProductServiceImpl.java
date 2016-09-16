package com.auction.couchdb.service;

import com.auction.couchdb.exception.AlreadyExistsException;
import com.auction.couchdb.exception.AuctionException;
import com.auction.couchdb.exception.DoesNotExistException;
import com.auction.couchdb.repository.ProductRepository;
import com.auction.couchdb.repository.entity.Product;
import com.auction.couchdb.web.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hsupar on 9/16/2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		ProductServiceImpl.class);

	private final ProductConverter productConverter;

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(final ProductConverter productConverter,
		final ProductRepository productRepository) {
		this.productConverter = productConverter;
		this.productRepository = productRepository;
	}

	@Override
	public void save(final ProductDto productDto) {
		LOGGER.debug("Started saving product {}", productDto);
		if (productDto == null) {
			throw new AuctionException("Input for saving product is null");
		}
		if (productRepository.findByModel(productDto.getModel()) != null) {
			throw new AlreadyExistsException(
				"Model already exists for input " + productDto);
		}
		final Product product = productConverter.convert(productDto);
		final String id = productRepository.save(product);
		LOGGER.debug("Finished saving product {} with id {}", productDto, id);
	}
}
