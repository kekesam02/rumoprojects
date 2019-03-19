package com.itbooking.service.item;

import java.util.List;
import java.util.Map;

import com.itbooking.pojo.Item;
import com.itbooking.vo.Params;

public interface IItemService {
	
	/**
	 * 
	 *  保存商品管理
	 * 方法名：saveItem<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param item
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Item saveItem(Item item);
	
	/**
	 * 
	 * (修改商品管理)<br/>
	 * 方法名：updateItem<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月01日 22:02:06 <br/>
	 * 手机:1564545646464<br/>
	 * @param item
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int updateItem(Item item);
	
	/**
	 * 
	 * (根据id删除商品管理)<br/>
	 * 方法名：deleteItemById<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月01日 22:02:06 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int deleteItemById(Long id);
	
	/**
	 * 
	 * (根据id获取商品管理)<br/>
	 * 方法名：getItemById<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月01日 22:02:06 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Item getItemById(Long id);
	
	/**
	 * 
	 * (查询所有的商品管理)<br/>
	 * 方法名：queryItemAll<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月01日 22:02:06 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<Item> queryItemAll();
	
	
	public Map<String, Object> queryItemAllPage(Params params);
	
	/**
	 * 根据id修改url地址
	 * 方法名：updateItemUrl<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年3月12日-下午9:47:58 <br/>
	 * 手机/微信:15074816437<br/>
	 * @param id
	 * @param url
	 * @return int<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int updateItemUrl(Long id,String url);
}
