package com.itbooking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbooking.service.SItemService;
import com.itbooking.service.SearchRelationService;
import com.itbooking.vo.SItem;

@Controller
public class SeachEnginController {

	// 服务远程dubbo--用来调用商品信息，进行索引化操作
	@Autowired
	private SearchRelationService searchRelationService;
	
	// 搜索服务
	@Autowired
	private SItemService sItemService;
	
	@GetMapping("/tosearch")
	public String toSearch() {
		return "search";
	}
	
	/**
	 * 跳转到搜索页面
	 * todo : 
	 * http://localhost:9400/search
	 * http://localhost:9400/search?q=%E5%93%88%E5%93%88
	 * @param keyword
	 * @return
	 */
	@GetMapping("/search")
	@ResponseBody
	public Page<SItem> search(@RequestParam(name="q",required=false)String keyword) {
		Page<SItem> pages = sItemService.pageQueyAll(keyword, 0,10);
		return pages;
	}
	
	@GetMapping("/search2")
	@ResponseBody
	public Page<SItem> search2(@RequestParam(name="q",required=false)String keyword) {
		Page<SItem> pages = sItemService.pageQuery(0, 10,keyword);
		return pages;
	}
	
	@GetMapping("/createindex")
	@ResponseBody
	public String cretaeIndex() {
		searchRelationService.createIndex();
		return "success";
	}
	
}
