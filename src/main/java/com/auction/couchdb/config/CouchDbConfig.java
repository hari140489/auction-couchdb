package com.auction.couchdb.config;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hsupar on 9/15/2016.
 */
@Configuration
public class CouchDbConfig {

	@Bean
	public CouchbaseCluster couchbaseCluster() {
		return CouchbaseCluster.create();
	}

	@Bean
	public Bucket userBucket() {
		return couchbaseCluster().openBucket("user");
	}

	@Bean
	public Bucket productBucket() {
		return couchbaseCluster().openBucket("product");
	}

	@Bean
	public Bucket bidBucket() {
		return couchbaseCluster().openBucket("bid");
	}
}
