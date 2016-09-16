package com.auction.couchdb.service;

import com.auction.couchdb.web.dto.ProductDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface ProductService {

	void save(ProductDto productDto);
}
