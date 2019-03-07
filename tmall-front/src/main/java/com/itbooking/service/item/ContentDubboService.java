package com.itbooking.service.item;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itbooking.pojo.Content;
import com.itbooking.service.content.IContentService;

/**
 * 
 * 调用dubbo服务接口的service类
 * ContentDubboService<br/>
 * 创建人:xuchengfeifei<br/>
 * 手机/微信:15074816437<br/> 
 * 时间：2019年3月7日-下午9:33:54 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class ContentDubboService {
	
	@Reference(check=false)
	private IContentService contentService;
	
	/**
	 * 根据分类id查询对应的轮展数据信息
	 * 方法名：findContents<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年3月7日-下午9:34:06 <br/>
	 * 手机/微信:15074816437<br/>
	 * @param categoryId
	 * @param pageNo
	 * @param pageSize
	 * @return List<Content><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<Content> findContents(Long categoryId,int pageNo,int pageSize){
		if(categoryId == null)return null;
		return contentService.findContentsByCategoryId(categoryId, pageNo, pageSize);
	}
	
}
