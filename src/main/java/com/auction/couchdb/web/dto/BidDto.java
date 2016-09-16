package com.auction.couchdb.web.dto;

import java.time.LocalDateTime;

/**
 * Created by hsupar on 9/16/2016.
 */
public class BidDto {

	private String productId;

	private String startAmount;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

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

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "BidDto{" + "productId='" + productId + "', startAmount='"
			+ startAmount + "', startDate='" + startDate + "', endDate='"
			+ endDate + "'}";
	}
}
