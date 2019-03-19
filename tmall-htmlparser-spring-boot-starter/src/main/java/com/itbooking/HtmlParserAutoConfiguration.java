package com.itbooking;

import org.jsoup.Jsoup;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@ConditionalOnClass({Jsoup.class})
@EnableConfigurationProperties(HtmlParserProperties.class)
public class HtmlParserAutoConfiguration {
	
	@Bean
	public HtmlParserService getHtmlParserService(HtmlParserProperties properties) {
		HtmlParserService htmlParser = new HtmlParserService();
		htmlParser.setAuthor(properties.getAuthor());
		htmlParser.setUrl(properties.getUrl());
		htmlParser.setName(properties.getName());
		return htmlParser;
	}
}
