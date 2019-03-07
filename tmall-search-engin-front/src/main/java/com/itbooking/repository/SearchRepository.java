//package com.itbooking.repository;
//
//import java.util.List;
//
//public interface SearchRepository<T> {
//	
//	public void save(T item);
//	public void delete(T item);
//	public T getByName(Long id);
//	public List<T> findAll();
//	
//	// 模板模式--
//	// :  Elasticsearch 肯定一定初始化一个TransportClient
//	// 1: 当pom.xml依赖es，会springboot的starter机制会自动去装配 ElasticsearchAutoConfiguration。
//	// 2 : 初始化 TransportClient  
//	/*
//	 * 	@Bean
//		@ConditionalOnMissingBean
//		public TransportClient elasticsearchClient() throws Exception {
//			TransportClientFactoryBean factory = new TransportClientFactoryBean();
//			factory.setClusterNodes(this.properties.getClusterNodes());
//			factory.setProperties(createProperties());
//			factory.afterPropertiesSet();
//			return factory.getObject();
//		}
//	 * */
//	
//	// springdata -- 里面提供对
//}