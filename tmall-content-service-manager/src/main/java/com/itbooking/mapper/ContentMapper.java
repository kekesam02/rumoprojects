package com.itbooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbooking.pojo.Content;
import com.itbooking.vo.Params;


/**
 * 
 * todo:商品管理
 * Content<br/>
 * 创建人:xuchengfeifei<br/>
 * 时间：2019年03月07日 20:44:03 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface ContentMapper {
	
	/**
	 * 根据category查询对应的轮展位
	 * 方法名：findContentsByCategoryId<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年3月7日-下午9:19:07 <br/>
	 * 手机/微信:15074816437<br/>
	 * @param categoryId
	 * @return List<Content><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<Content> findContentsByCategoryId(@Param("categoryId")Long categoryId);
}