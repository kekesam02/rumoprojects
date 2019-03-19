package com.itbooking.freemaker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.itbooking.util.RequestUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class StaticFreemakerUtil  implements ApplicationContextAware{

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private FreeMarkerViewResolver resolver;
	
	private ApplicationContext context;
	
//	@Autowired
//	private BooksMapper booksMapper;
	
//	public  String bookid(HttpServletRequest request) {
//		try {
//			Map<String, Object> root = new HashMap<>();
//			root.put("request", request);
//			root.put("basePath", RequestUtil.getBasePath(request));
//			root.put("resourcePath", "http://www.itbooking.net/itresources");
//			root.put("rootPath", RequestUtil.getBasePath(request));
//			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
//			resolver.setViewClass(FreemarkerView.class);
//			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
//			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
//				root.put(entry.getKey(), entry.getValue());
//			}
//			
//			// 指定静态化文件存放的目录，如果你是一个web项目可以直接使用request.getContextServlet().getRealPath("/");
//			File templatePath = ResourceUtils.getFile("classpath:templates");
//			String rootPath = request.getServletContext().getRealPath("/books");
//			
//			//查询所有的博客
//			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
//			Books books = booksMapper.getBooks2(bookId);
//			root.put("id", bookId);
//			String filename = books.getStaticLink()==null?null:books.getStaticLink();
//			if(TmStringUtils.isEmpty(filename)) {
//				filename = TmStringUtils.getRandomString(10)+books.getId()+TmStringUtils.getRandomString(10)+".html";
//			}else {
//				filename = filename.replaceAll("books\\/","");
//			}
//			Configuration configuration = freeMarkerConfigurer.getConfiguration();
//			// 得到模板
//			// 如果你分父目录不存在，递归创建
//			File parentPath = new File(rootPath);
//			if (!parentPath.exists())
//				parentPath.mkdirs();
//			// 组合最终的文件路径
//			File targetFile = new File(parentPath, filename);
//			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
//			configuration.setDirectoryForTemplateLoading(templatePath);
//			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
//			// 读取模板
//			Template template = configuration.getTemplate("books/content.html","UTF-8");
//			try {
//				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
//				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
//				FileUtils.write(targetFile, text, "UTF-8");
//				
//				//修改
//				String staticLink = "books/"+filename;
//				Books books2 = new Books();
//				books2.setId(books.getId());
//				books2.setStaticLink(staticLink);
//				booksMapper.updateBooks(books2);
//				
//			} catch (TemplateException e) {
//				e.printStackTrace();
//				return null;
//			}
//			return "success";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public  String books(HttpServletRequest request) {
//		try {
//			Map<String, Object> root = new HashMap<>();
//			root.put("request", request);
//			root.put("basePath", RequestUtil.getBasePath(request));
//			root.put("resourcePath", "http://www.itbooking.net/itresources");
//			root.put("rootPath", RequestUtil.getBasePath(request));
//			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
//			resolver.setViewClass(FreemarkerView.class);
//			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
//			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
//				root.put(entry.getKey(), entry.getValue());
//			}
//			
//			File templatePath = ResourceUtils.getFile("classpath:templates");
//			String rootPath = request.getServletContext().getRealPath("/books");
//			
//			//查询所有的博客
//			TmParams params = new TmParams();
//			params.setPageSize(5000);
//			List<HashMap<String, Object>> blogs = booksMapper.findBooks(params);
//			for (HashMap<String, Object> blog : blogs) {
//				root.put("id", blog.get("id"));
//				String filename = blog.get("staticLink")==null?null:String.valueOf(blog.get("staticLink"));
//				if(TmStringUtils.isEmpty(filename)) {
//					filename = TmStringUtils.getRandomString(10)+blog.get("id")+TmStringUtils.getRandomString(10)+".html";
//				}else {
//					filename = filename.replaceAll("books\\/","");
//				}
//				Configuration configuration = freeMarkerConfigurer.getConfiguration();
//				// 得到模板
//				// 如果你分父目录不存在，递归创建
//				File parentPath = new File(rootPath);
//				if (!parentPath.exists())
//					parentPath.mkdirs();
//				// 组合最终的文件路径
//				File targetFile = new File(parentPath, filename);
//				//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
//				configuration.setDirectoryForTemplateLoading(templatePath);
//				configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
//				// 读取模板
//				Template template = configuration.getTemplate("books/content.html","UTF-8");
//				try {
//					// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
//					String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
//					FileUtils.write(targetFile, text, "UTF-8");
//					//修改
//					String staticLink = "books/"+filename;
//					Books books2 = new Books();
//					books2.setId(Integer.parseInt(String.valueOf(blog.get("id"))));
//					books2.setStaticLink(staticLink);
//					booksMapper.updateBooks(books2);
//				} catch (TemplateException e) {
//					e.printStackTrace();
//					return null;
//				}
//			}
//			return "success";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
	
	public  String index(HttpServletRequest request) {
		try {
			Map<String, Object> root = new HashMap<>();
			root.put("request", request);
			root.put("resourcePath", "http://www.itbooking.net/itresources");
			root.put("rootPath", RequestUtil.getBasePath(request));
			root.put("basePath", RequestUtil.getBasePath(request));
			root.put("adminPath", RequestUtil.getBasePath(request)+"/admin");
			
			resolver.setViewClass(FreemarkerView.class);
			Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
			for (Entry<String, TemplateModel> entry : beans.entrySet()) {
				root.put(entry.getKey(), entry.getValue());
			}
			
			File templatePath = ResourceUtils.getFile("classpath:templates");
			String rootPath = request.getServletContext().getRealPath("/");
			String filename = "newindex.html";
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			// 得到模板
			// 如果你分父目录不存在，递归创建
			File parentPath = new File(rootPath);
			if (!parentPath.exists())
				parentPath.mkdirs();
			// 组合最终的文件路径
			File targetFile = new File(parentPath, filename);
			//不需要设定模板的路径了，因为springboot会自动去装配模板路径了
			configuration.setDirectoryForTemplateLoading(templatePath);
			configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 读取模板
			Template template = configuration.getTemplate("index.html","UTF-8");
			try {
				// 将数据和模板中要动态替换的内容进行融合渲染，返回渲染以后的网页内容
				String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
				FileUtils.write(targetFile, text, "UTF-8");
				return filename;
			} catch (TemplateException e) {
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
