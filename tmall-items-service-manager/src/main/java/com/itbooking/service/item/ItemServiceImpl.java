package com.itbooking.service.item;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itbooking.mapper.ItemMapper;
import com.itbooking.pojo.Item;
import com.itbooking.vo.Params;


/**
 * 
 * todo:商品管理Service实现类
 * ItemServiceImpl<br/>
 * 作者:xuchengfeifei<br/>
 * 创建时间：2019年03月01日 22:02:06 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
@Component
public class ItemServiceImpl implements IItemService  {

	@Autowired
	private ItemMapper itemMapper;
	
	public Map<String, Object> queryItemAllPage(Params params){
		PageHelper.startPage(params.getPageNo(), params.getPageSize());
		List<Item> items = itemMapper.queryItemAll(params);
		PageInfo<Item> pageInfo = new PageInfo<>(items);
		Map<String, Object> map = new HashMap<>();
		map.put("data",pageInfo);
		return map;
	}
	
	public List<Item> queryItemAll(){
		List<Item> items = itemMapper.queryItemAll(null);
		return items;
	}
	
	@Override
	public Item saveItem(Item item) {
		int count = itemMapper.saveItem(item);
		return count >0 ? item : null;
	}
	
	
	
	
	
	
	@Override
	public int updateItem(Item item) {
		return itemMapper.updateItem(item);
	}

	
	@Override
	public int deleteItemById(Long id) {
		return itemMapper.deleteItemById(id);
	}

	
	@Override
	public Item getItemById(Long id) {
		Item item = itemMapper.getItemById(id);
		return item;
	}
	
}
