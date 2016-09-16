package com.auction.couchdb.web.dto;

/**
 * Created by hsupar on 9/16/2016.
 */
public class AuctionDto {

	private String id;

	private String bidId;

	private String email;

	private String amount;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(final String bidId) {
		this.bidId = bidId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(final String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AuctionDto{" + "id='" + id + "', bidId='" + bidId + "', email='"
			+ email + "', amount='" + amount + "'}";
	}
}
