package com.itbooking.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootConfiguration
public class RedisPoolConfiguration {

	@Autowired
	RedisConfiguration redisConfig;

	@Bean
	public JedisPool JedisPoolFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
		// 密码版本
		//JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
		//		redisConfig.getTimeout() * 1000, redisConfig.getPassword(), 0);
		JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),redisConfig.getTimeout() * 1000);
		return jp;
	}

}