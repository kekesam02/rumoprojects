package com.itbooking.service.content;

import java.util.List;

import com.itbooking.pojo.Content;

public interface IContentService {
	
	
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
	public List<Content> findContentsByCategoryId(Long categoryId,int pageNo,int pageSize);
	
	
}
