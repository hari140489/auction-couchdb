package com.auction.couchdb.exception;

/**
 * Created by hsupar on 9/16/2016.
 */
public class AlreadyExistsException extends RuntimeException {

	public AlreadyExistsException(final String message) {
		super(message);
	}

	public AlreadyExistsException(final String message,
		final Throwable cause) {
		super(message, cause);
	}

	public AlreadyExistsException(final Throwable cause) {
		super(cause);
	}

	public AlreadyExistsException(final String message,
		final Throwable cause, final boolean enableSuppression,
		final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
