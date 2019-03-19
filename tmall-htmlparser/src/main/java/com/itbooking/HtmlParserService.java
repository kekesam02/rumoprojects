package com.itbooking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;


public class HtmlParserService {

	private String name;
	private String author;
	private String url;
	
	//解析方法
	public String htmlParser() {
		try {
			String htmlsource = Jsoup.parse(new URL(this.url), 3000).html();
			return htmlsource;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

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
