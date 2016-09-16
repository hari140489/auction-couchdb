package com.auction.couchdb.repository.entity;

import java.util.Date;

/**
 * Created by hsupar on 9/16/2016.
 */
public class Bid {

	private String id;

	private String productId;

	private String startAmount;

	private Date startDate;

	private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(final String productId) {
		this.productId = productId;
	}

	public String getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(final String startAmount) {
		this.startAmount = startAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Bid{" + "id='" + id + "', productId='" + productId
			+ "', startAmount='" + startAmount + "', startDate=" + startDate
			+ "', endDate=" + endDate + "'}";
	}
}
