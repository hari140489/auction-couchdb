package com.auction.couchdb.web.dto;

/**
 * Created by hsupar on 9/16/2016.
 */
public class ProductDto {

	private String name;

	private String model;

	private String category;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(final String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDto{" + "name='" + name + "', model='" + model
			+ "', category='" + category + "'}";
	}
}
