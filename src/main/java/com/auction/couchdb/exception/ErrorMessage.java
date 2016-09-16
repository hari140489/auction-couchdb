package com.auction.couchdb.exception;

import java.time.LocalDateTime;

/**
 * Created by hsupar on 9/16/2016.
 */
public class ErrorMessage {

	private String message;

	private LocalDateTime time;

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(final LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ErrorMessage{" + "message='" + message + "', time=" + time
			+ "'}";
	}
}
