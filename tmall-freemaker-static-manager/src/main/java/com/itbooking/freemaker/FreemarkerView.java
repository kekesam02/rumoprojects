package com.itbooking.freemaker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.itbooking.util.RequestUtil;

public class FreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String base = RequestUtil.getBasePath(request);
		model.put("basePath", base);
		model.put("adminPath", base+"/admin");
		model.put("resourcePath", "http://www.itbooking.net/itresources");
		super.exposeHelpers(model, request);
	}
}
