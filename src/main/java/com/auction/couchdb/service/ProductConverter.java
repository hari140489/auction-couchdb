package com.auction.couchdb.service;

import com.auction.couchdb.generic.Converter;
import com.auction.couchdb.repository.entity.Product;
import com.auction.couchdb.web.dto.ProductDto;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface ProductConverter extends Converter<ProductDto, Product> {

}
