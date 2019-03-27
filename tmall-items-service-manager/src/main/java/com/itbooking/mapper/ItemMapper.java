package com.itbooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbooking.pojo.Item;
import com.itbooking.vo.Params;


/**
 * 
 * todo:商品管理
 * Item<br/>
 * 创建人:xuchengfeifei<br/>
 * 时间：2019年03月01日 22:02:06 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface ItemMapper {
	//添加
	public int saveItem(Item item);
	//修改
	public int updateItem(Item item);
	// 更新静态化URL地址
	public int updateItemUrl(@Param("id") Long id, @Param("url") String url);
	//删除
	public int deleteItemById(@Param("id") Long id);
	//查询单个
	public Item getItemById(@Param("id") Long id);
	//查询所有
	public List<Item> queryItemAll(Params params);
	
	
}