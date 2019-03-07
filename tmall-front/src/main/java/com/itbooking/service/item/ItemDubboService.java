package com.itbooking.service.item;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itbooking.pojo.Item;
import com.itbooking.vo.Params;

@Service
public class ItemDubboService {
	
	// dubbo服务的引用  @Reference 服务的消费方 3
	@Reference(check=false,timeout=5000,retries=2)
	private IItemService itemService;
	
	
	public Item getItem(Long id) {
		Item item = itemService.getItemById(id);
		return item;
	}
	
	public Map<String, Object> findItems(Params params) {
		return itemService.queryItemAllPage(params);
	}
	
}
