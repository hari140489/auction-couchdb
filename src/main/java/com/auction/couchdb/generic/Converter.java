package com.auction.couchdb.generic;

/**
 * Created by hsupar on 9/16/2016.
 */
public interface Converter<From, To> {

	To convert(From from);
}
