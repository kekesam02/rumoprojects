package com.itbooking.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbooking.freemaker.StaticFreemakerUtil;

@RestController
public class StaticController {

	@Autowired
	private StaticFreemakerUtil staticFreemakerUtil;
	
	@GetMapping("/static/index")
	public String staticindex(HttpServletRequest request) {
		staticFreemakerUtil.index(request);
		return "success";
	}
}
