package com.auction.couchdb.repository;

import com.auction.couchdb.exception.AuctionException;
import com.auction.couchdb.repository.entity.Product;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by hsupar on 9/16/2016.
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(
		ProductRepositoryImpl.class);

	private final ObjectMapper couchBaseDbObjectMapper;

	private final Bucket productBucket;

	@Autowired
	public ProductRepositoryImpl(final ObjectMapper couchBaseDbObjectMapper,
		final Bucket productBucket) {
		this.couchBaseDbObjectMapper = couchBaseDbObjectMapper;
		this.productBucket = productBucket;
	}

	@Override
	public String save(final Product product) {
		LOGGER.debug("Saving product in repository {}", product);
		try {
			final String id = UUID.randomUUID().toString();
			product.setId(id);
			final String productJson = couchBaseDbObjectMapper.writeValueAsString(
				product);
			productBucket.insert(
				JsonDocument.create(id, JsonObject.fromJson(productJson)));
			LOGGER.debug("Finished saving product in repository {}", product);
			return id;
		}
		catch (JsonProcessingException e) {
			throw new RuntimeException("Unable to save product " + product, e);
		}
	}

	@Override
	public Product findOne(final String productId) {
		LOGGER.debug("Fetching product with id {}", productId);
		final N1qlQueryResult result = productBucket.query(
			N1qlQuery.parameterized(
				"SELECT id, name, model, category from product where id=$productId",
				JsonObject.create().put("productId", productId)));
		Product product = null;
		for (N1qlQueryRow row : result) {
			try {
				product = couchBaseDbObjectMapper.readValue(row.value().toString(), Product.class);
			}
			catch (IOException e) {
				throw new AuctionException(
					"Error in fetching product for the input id " + productId);
			}
		}
		LOGGER.debug("Finished fetching product {} with id {}", product,
			productId);
		return product;
	}

	@Override
	public Product findByModel(final String model) {
		LOGGER.debug("Fetching product with model {]", model);
		final N1qlQueryResult result = productBucket.query(
			N1qlQuery.parameterized(
				"SELECT id, name, model, category from product where model=$model",
				JsonObject.create().put("model", model)));
		Product product = null;
		for (N1qlQueryRow row : result) {
			try {
				product = couchBaseDbObjectMapper.readValue(
					row.value().toString(), Product.class);
			}
			catch (IOException e) {
				throw new AuctionException(
					"Error in fetching product for the model " + model);
			}
		}
		LOGGER.debug("Finished fetching product {} with model {}", product,
			model);
		return product;
	}
}
