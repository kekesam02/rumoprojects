package com.itbooking.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbooking.pojo.Content;
import com.itbooking.service.content.IContentService;

/**
 * 
 * todo:商品管理Controller控制器类
 * ContentController<br/>
 * 作者:xuchengfeifei<br/>
 * 创建时间：2019年03月07日 20:44:03 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	@GetMapping("/findcontents/{categoryId}")
	@ResponseBody
	public List<Content> findContents(@PathVariable("categoryId")Long categoryId) {
		return contentService.findContentsByCategoryId(categoryId, 1,10);
	}

	
}
