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
public class KeyController {

	/**
	 * 跳转到搜索页面 todo : http://localhost:9400/search
	 * http://localhost:9400/search?q=%E5%93%88%E5%93%88
	 * 
	 * @param keyword
	 * @return
	 */
//	@GetMapping("/keywords")
//	public String keywords() {
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("莫风老师\r\n");
//		buffer.append("徐成飞\r\n");
//		buffer.append("张三你好\r\n");
//		buffer.append("李四你好\r\n");
//		buffer.append("带泥老姜\r\n");
//		return buffer.toString();
//	}

	@GetMapping("/keywords.dic")
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
			list.add("天气晴朗不错");
			String oldEtag = list.size() + "";
			StringBuffer sb = new StringBuffer();
			if (oldEtag != eTag) {

				for (String str : list) {
//					if (StringUtils.isNotEmpty(str)) {
//						sb.append("\r\n");
//					}
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

	@GetMapping("/stopwords.dic")
	public String stopwords() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("哈哈\r\n");
		buffer.append("为什么\r\n");
		return buffer.toString();
	}

}
