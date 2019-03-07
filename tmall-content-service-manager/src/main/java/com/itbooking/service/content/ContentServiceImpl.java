package com.itbooking.service.content;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itbooking.mapper.ContentMapper;
import com.itbooking.pojo.Content;
import com.itbooking.vo.ServerResponse;


/**
 * 
 * todo:商品管理Service实现类
 * ContentServiceImpl<br/>
 * 作者:xuchengfeifei<br/>
 * 创建时间：2019年03月07日 20:44:03 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
@Component
public class ContentServiceImpl implements IContentService  {

	@Autowired
	private ContentMapper contentMapper;
	
	public List<Content> findContentsByCategoryId(Long categoryId,int pageNo,int pageSize){
		PageHelper.startPage(pageNo, pageSize);
		List<Content> contents = contentMapper.findContentsByCategoryId(categoryId);
		PageInfo<Content> pageInfo = new PageInfo<>(contents);
		return pageInfo.getList();
	}
	
	
	
}
