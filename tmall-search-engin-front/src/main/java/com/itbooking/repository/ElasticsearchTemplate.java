//package com.itbooking.repository;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ElasticsearchTemplate {
//
//
//	@Autowired
//	TransportClient transportClient;
//	
//	
//	public void execute(RowCallback rowCallback) {
//		try {
//			rowCallback.doCallback(transportClient);
//		} finally {
//			transportClient.close();
//		}
//	}
//	
//	// index
//	// putmmaping
//	// queryList
//}
