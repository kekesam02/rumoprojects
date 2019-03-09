package com.itbooking.redis;
public class ItemKey2 extends BasePrefix{
	
	// 不为封装而封装，而发现你定义大量类出现了很多相同的逻辑和属性，这个一定要用面向
	//spring data
	public ItemKey2(String key) {
		super(key);
	}
	
	public ItemKey2(String key,int expireSeconds) {
		super(key,expireSeconds);
	}
	
	// 服务于首页数据商品返回
	public static ItemKey2 itemKey2 = new ItemKey2("index_items");
	// 服务于首页数据商品返回
	public static ItemKey2 itemKey3 = new ItemKey2("admin_items",5);

}
