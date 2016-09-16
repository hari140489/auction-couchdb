package com.auction.couchdb.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by hsupar on 9/16/2016.
 */
public final class DateUtilities {

	private DateUtilities() {
	}

	public static Date toDate(final LocalDateTime localDateTime) {
		if (localDateTime != null) {
			return Date.from(
				localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}
}
