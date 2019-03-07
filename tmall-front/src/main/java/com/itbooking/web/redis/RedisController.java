package com.itbooking.web.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbooking.redis.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	
	@Autowired
	private RedisService redisService;
	
	
	// 第三节课： springboot 将starter机制
	@GetMapping("/set/{value}")
	public int set(@PathVariable("value")String value) {
		return redisService.set("username", value);
	}
	
	@GetMapping("/get")
	public String get() {
		return redisService.get("username");
	}
	
	@GetMapping("/del")
	public boolean del() {
		return redisService.del("username");
	}
}
