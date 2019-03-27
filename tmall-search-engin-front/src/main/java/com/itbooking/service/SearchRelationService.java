//package com.itbooking.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.itbooking.pojo.Item;
//import com.itbooking.service.item.IItemService;
//import com.itbooking.vo.SItem;
//
//@Service
//public class SearchRelationService {
//
//	//dubbo 会在注册照中心找到对应的远程服务的信息，--然后找到当前spring容器,然后在创建一个对象
//	// 动态代理 192.168.1.159 192.168.1.160
//	@Reference
//	private IItemService itemSerivce;
//
//	@Autowired
//	private SItemService sItemService;
//
//
//	public void createIndex() {
//		//通过dubbo去查询，商品信息
//		List<Item> items =   itemSerivce.queryItemAll();
//		for(Item item:items) {
//			SItem sitem = new SItem();
//			sitem.setId(item.getId()+"");
//			sitem.setImg(item.getImage());
//			sitem.setTitle(item.getTitle());
//			sitem.setSellPoint(item.getSellPoint());
//			sitem.setPrice(item.getPrice());
//			sitem.setStatus(Integer.parseInt(item.getStatus()));
//			sitem.setDate(item.getCreateTime());
//			//把查询的商品信息，索引化，为后续提供搜索服务
//			sItemService.save(sitem);
//		}
//	}
//}
