package com.itbooking.service;

import com.itbooking.pojo.Item;
import com.itbooking.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MQSearchRelationService {


	@Autowired
	private ItemService sItemService;

	@JmsListener(destination = "mq.staticindexcache.item.save")
	public void createIndex(String itemJson) {
		System.out.println("topic-----createIndex-------->索引化进入了"+ itemJson);
		Item item = JsonUtil.string2Obj(itemJson,Item.class);
		com.itbooking.vo.Item sitem = new com.itbooking.vo.Item();
		sitem.setId(item.getId()+"");
		sitem.setImg(item.getImage());
		sitem.setTitle(item.getTitle());
		sitem.setSellPoint(item.getSellPoint());
		sitem.setPrice(item.getPrice());
		sitem.setStatus(Integer.parseInt(item.getStatus()));
		sitem.setDate(item.getCreateTime());
	    sItemService.save(sitem);
	}

	@JmsListener(destination = "mq.staticindexcache.item.update")
	public void updateIndex(String itemJson) {
		System.out.println("topic-------updateIndex ------>索引化进入了"+ itemJson);
		Item item = JsonUtil.string2Obj(itemJson,Item.class);
		com.itbooking.vo.Item sitem = new com.itbooking.vo.Item();
		sitem.setId(item.getId()+"");
		sitem.setImg(item.getImage());
		sitem.setTitle(item.getTitle());
		sitem.setSellPoint(item.getSellPoint());
		sitem.setPrice(item.getPrice());
		sitem.setStatus(Integer.parseInt(item.getStatus()));
		sitem.setDate(item.getCreateTime());
		sItemService.update(sitem);
	}

	@JmsListener(destination = "mq.staticindexcache.item.delete")
	public void deleteIndex(String itemId) {
		System.out.println("topic-------deleteIndex ------>索引化进入了"+ itemId);
		sItemService.deleteById(itemId);
	}
}
