//package com.itbooking.repository;
//
//import java.util.List;
//
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.itbooking.vo.SItem;
//
//@Repository
//public class ItemRepositoryImpl implements SearchRepository<SItem> {
//	
//	@Autowired
//	private ElasticsearchTemplate elasticsearchTemplate;
//	
//	
//	
//	public void save(SItem item) {
//		// 2: 准备文档对象
//		elasticsearchTemplate.execute(new RowCallback() {
//			@Override
//			public void doCallback(TransportClient transportClient) {
//				String json;
//				try {
//					json = new ObjectMapper().writeValueAsString(item);
//					// 3：索引化
//					IndexResponse response =  transportClient.prepareIndex("blogs","blog","doc1")
//							.setSource(json).get();
//					System.out.println("索引状态是：" + response.status());
//				} catch (JsonProcessingException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}
//
//
//	@Override
//	public void delete(SItem item) {
//		
//	}
//
//
//	@Override
//	public SItem getByName(Long id) {
//		return null;
//	}
//
//
//	@Override
//	public List<SItem> findAll() {
//		elasticsearchTemplate.execute(new RowCallback() {
//			
//			@Override
//			public void doCallback(TransportClient transportClient) {
//				 QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
//		         SearchResponse response =  transportClient.prepareSearch("")
//		                .setTypes(TYPE_NAME)
//		                .setQuery(queryBuilder).get();
//
//			}
//		});
//	}
//	
//	
//	
//}