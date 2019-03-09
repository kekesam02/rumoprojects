package com.itbooking.redis;
public class UserKey3 extends BasePrefix {
	
	public UserKey3(String key) {
		super(key);
	}
	
	public UserKey3(String key,int expireSeconds) {
		super(key,expireSeconds);
	}
	
	// 服务于首页数据商品返回
	public static UserKey3 userKey2 = new UserKey3("index_user");
	// 服务于首页数据商品返回
	public static UserKey3 userKey3 = new UserKey3("admin_user",5);

	

}
