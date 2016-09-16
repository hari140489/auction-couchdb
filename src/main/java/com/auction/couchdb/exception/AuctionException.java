package com.auction.couchdb.exception;

/**
 * Created by hsupar on 9/16/2016.
 */
public class AuctionException extends RuntimeException {

	public AuctionException(final String message) {
		super(message);
	}

	public AuctionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AuctionException(final Throwable cause) {
		super(cause);
	}

	public AuctionException(final String message, final Throwable cause,
		final boolean enableSuppression, final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
