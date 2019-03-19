package com.itbooking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/{path}")
	public String toPath(@PathVariable("path")String path) {
		return path;
	}
	
}
