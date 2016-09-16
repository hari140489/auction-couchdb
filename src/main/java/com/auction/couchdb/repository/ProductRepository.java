package com.auction.couchdb.repository;

import com.auction.couchdb.repository.entity.Product;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface ProductRepository {

	String save(Product product);

	Product findOne(String productId);
}
