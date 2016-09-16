package com.auction.couchdb.service;

import com.auction.couchdb.repository.entity.Product;
import com.auction.couchdb.web.dto.ProductDto;
import org.springframework.stereotype.Component;

/**
 * Created by hsupar on 9/16/2016.
 */
@Component
public class ProductConverterImpl implements ProductConverter {

	@Override
	public Product convert(final ProductDto productDto) {
		final Product product = new Product();
		product.setName(productDto.getName());
		product.setModel(productDto.getModel());
		product.setCategory(productDto.getCategory());
		return product;
	}
}
