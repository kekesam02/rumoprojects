package com.itbooking.web;

import com.itbooking.service.ItemService;
import com.itbooking.service.MQSearchRelationService;
import com.itbooking.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeachEnginController {


	// 搜索服务
	@Autowired
	private ItemService itemService;

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
	public Page<Item> search(@RequestParam(name="q",required=false)String keyword) {
		Page<Item> pages = itemService.pageQueyAll(keyword, 0,10);
		return pages;
	}

	@GetMapping("/search2")
	@ResponseBody
	public Page<Item> search2(@RequestParam(name="q",required=false)String keyword) {
		Page<Item> pages = itemService.pageQuery(0, 10,keyword);
		return pages;
	}


}
