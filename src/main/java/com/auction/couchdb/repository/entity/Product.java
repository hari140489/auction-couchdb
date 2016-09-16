package com.auction.couchdb.repository.entity;

/**
 * Created by hsupar on 9/16/2016.
 */
public class Product {

	private String id;

	private String name;

	private String category;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + "', name='" + name + "', category='"
			+ category + "'}";
	}
}
