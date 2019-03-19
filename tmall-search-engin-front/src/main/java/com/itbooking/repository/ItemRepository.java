package com.itbooking.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.itbooking.vo.SItem;

@Repository
public interface ItemRepository extends ElasticsearchRepository<SItem, String> {
	
	
	
}