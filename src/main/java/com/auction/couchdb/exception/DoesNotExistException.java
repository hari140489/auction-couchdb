package com.auction.couchdb.exception;

/**
 * Created by hsupar on 9/16/2016.
 */
public class DoesNotExistException extends RuntimeException {

	public DoesNotExistException(final String message) {
		super(message);
	}

	public DoesNotExistException(final String message,
		final Throwable cause) {
		super(message, cause);
	}

	public DoesNotExistException(final Throwable cause) {
		super(cause);
	}

	public DoesNotExistException(final String message,
		final Throwable cause, final boolean enableSuppression,
		final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
