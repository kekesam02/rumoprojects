package com.itbooking.redis;
public abstract class BasePrefix implements KeyPrefix {

	private int expireSeconds;
	private String key;
	
	// 抽象类是不能new,但是有构造函数，抽象类的构造函数只有一个一个作用
	// 就是让子类的super()进行给当前抽象成员属性
	public BasePrefix(String key) {
		this.key = key;
		this.expireSeconds = 0;
	}
	
	public BasePrefix(String key,int expireSeconds) {
		this.key = key;
		this.expireSeconds = expireSeconds;
	}
	
	@Override
	public int expireSeconds() {
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		return "rumo_"+this.getClass().getSimpleName() +":"+ key;
	}
}