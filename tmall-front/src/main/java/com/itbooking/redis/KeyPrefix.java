package com.itbooking.redis;

/**
 * 
 *  key管理接口
 * KeyPrefix<br/>
 * 创建人:xuchengfeifei<br/>
 * 手机/微信:15074816437<br/> 
 * 时间：2019年3月9日-下午8:25:01 <br/>
 * @version 1.0.0<br/>
 * 
 *KeyPrefix 
 *
 *set
 *get("ContentService_"+"findcontents:1")
 */
public interface KeyPrefix {
	// 过期时间
	public int expireSeconds();
	// 前缀
	public String getPrefix();
}