package com.itbooking.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeywordMangerController {

	// 业务扩展词的扩展
	// todo :http://127.0.0.1:9200/_analyze?analyzer=ik_smart&pretty=true&text=%E6%88%91%E6%98%AF%E7%A8%8B%E5%BA%8F%E5%91%98%EF%BC%8C%E8%8E%AB%E9%A3%8E%E8%80%81%E5%B8%88%E6%99%83%E6%99%83%E4%B9%8B%E7%B1%BB%E8%93%9D%E7%98%A6%E9%A6%99%E8%8F%87%E6%99%83%E6%99%83%E4%B9%8B%E7%B1%BB%E6%AF%9B%E6%B3%BD%E4%B8%9C%E5%BD%95%E5%83%8F%E6%9C%BA%E5%BE%88%E6%A3%92%E5%B8%A6%E6%B3%A5%E8%80%81%E5%A7%9C%E9%87%91%E9%92%88%E8%8F%87%E7%BA%A2%E7%9A%AE%E5%A4%A7%E8%92%9C
	@GetMapping("/hotwords.dic")
	public void loadDic(HttpServletRequest req, HttpServletResponse response) {
		String eTag = req.getParameter("If-None-Match");
		try {

			OutputStream out = response.getOutputStream();
			List<String> list = new ArrayList<String>();
			list.add("我中国");
			list.add("我爱你爱我");
			list.add("李四你好");
			list.add("勿忘第三方");
			list.add("带泥老姜");
			list.add("删掉我们");
			list.add("莫风老师");
			list.add("小米辣");
			list.add("大香芋");
			list.add("小葱头");
			list.add("老板是BOOS");
			list.add("天气晴朗不错");
			String oldEtag = list.size() + "";
			StringBuffer sb = new StringBuffer();
			if (oldEtag != eTag) {

				for (String str : list) {
					sb.append(str + "\r\n");
				}
			}
			String data = sb.toString();
			response.setHeader("Last-Modified", String.valueOf(list.size()));
			response.setHeader("ETag", String.valueOf(list.size()));
			response.setContentType("text/plain; charset=UTF-8");
			out.write(data.getBytes());
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// todo :http://127.0.0.1:9200/_analyze?analyzer=ik_smart&pretty=true&text=%E5%9D%8F%E4%BA%BA%E5%8F%AF%E6%80%95%E5%B0%8F%E7%B1%B3%E8%BE%A3%E5%A4%A7%E9%A6%99%E8%8A%8B%E7%8E%8B%E5%85%AB%E8%9B%8B%E5%9D%8F%E8%9B%8B%E5%B0%8F%E8%B4%B1%E8%B4%B1%E5%B8%A6%E6%B3%A5%E8%80%81%E5%A7%9C%E5%A4%A9%E6%B0%94%E6%99%B4%E6%9C%97%E4%B8%8D%E9%94%99%E8%80%81%E6%9D%BF%E6%98%AFBOOS%E5%B0%8F%E8%91%B1%E5%A4%B4
	@GetMapping("/stopwords.dic")
	public void loadDicstopwords(HttpServletRequest req, HttpServletResponse response) {
		String eTag = req.getParameter("If-None-Match");
		try {

			OutputStream out = response.getOutputStream();
			List<String> list = new ArrayList<String>();
			list.add("坏蛋");
			list.add("王八蛋");
			list.add("坏人可怕");
			String oldEtag = list.size() + "";
			StringBuffer sb = new StringBuffer();
			if (oldEtag != eTag) {

				for (String str : list) {
					sb.append(str + "\r\n");
				}
			}
			String data = sb.toString();
			response.setHeader("Last-Modified", String.valueOf(list.size()));
			response.setHeader("ETag", String.valueOf(list.size()));
			response.setContentType("text/plain; charset=UTF-8");
			out.write(data.getBytes());
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
