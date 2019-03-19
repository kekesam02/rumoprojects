package com.itbooking.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import freemarker.template.Template;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(ModelMap modelMap) {
		modelMap.put("name", "狗狗");
		modelMap.put("message", "我是一个帅气的小帅哥");
		
		List goodsList=new ArrayList();

		Map goods1=new HashMap();
		goods1.put("name", null);
		goods1.put("num", 1);
		goods1.put("price", 5.8);
		goods1.put("date", new Date());

		Map goods2=new HashMap();
		goods2.put("name", "香蕉");
		goods2.put("num", 2);
		goods2.put("price", 2.5);
		goods2.put("date", new Date());

		Map goods3=new HashMap();

		goods3.put("name", "橘子");
		goods3.put("num", 3);
		goods3.put("price", 3.2);
		goods3.put("date", new Date());
		
		goodsList.add(goods1);
		goodsList.add(goods2);
		goodsList.add(goods3);

		modelMap.put("goodsList", goodsList);
		
	
		return "index";
	}
}
