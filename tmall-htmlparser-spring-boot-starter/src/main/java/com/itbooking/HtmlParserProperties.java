package com.itbooking;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = HtmlParserProperties.HTMLPARSER_PREFIX)
public class HtmlParserProperties {

	
	public static final String HTMLPARSER_PREFIX = "itbooking.htmlparser";
	
	private String name;
	private String author;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	
	
	
}
