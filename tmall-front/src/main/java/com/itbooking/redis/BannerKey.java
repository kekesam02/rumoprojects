package com.itbooking.redis;
public class BannerKey extends BasePrefix {

	private BannerKey(String prefix) {
		super(prefix);
	}
	
	private BannerKey(String prefix,int senconds) {
		super(prefix,senconds);
	}

	// key 的扩展
	//查询banners--2
	public static BannerKey banners = new BannerKey("banners",100);
	// 美妆的banners
	public static BannerKey meizbanners = new BannerKey("meizhaugn_banners");
}
