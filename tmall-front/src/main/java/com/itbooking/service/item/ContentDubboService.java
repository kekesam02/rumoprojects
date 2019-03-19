package com.itbooking.service.item;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itbooking.pojo.Content;
import com.itbooking.redis.BannerKey;
import com.itbooking.redis.RedisService;
import com.itbooking.service.content.IContentService;

/**
 * 
 * 调用dubbo服务接口的service类
 * ContentDubboService<br/>
 * 创建人:xuchengfeifei<br/>
 * 手机/微信:15074816437<br/> 
 * 时间：2019年3月7日-下午9:33:54 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class ContentDubboService {
	
	private Logger log = LoggerFactory.getLogger(ContentDubboService.class);
	
	@Reference(check=false)
	private IContentService contentService;
//	@Autowired
//	private RedisService redisService;
	
	
	@Cacheable(value="banners",key="#root.methodName+':'+#categoryId")
	public List<Content> findContents(Long categoryId,int pageNo,int pageSize){
		if(categoryId == null)return null;
		List<Content> contents = contentService.findContentsByCategoryId(categoryId, pageNo, pageSize);
		return contents;
	}
	
	@CacheEvict(value="banners",key="#root.methodName+':'+#categoryId",allEntries=true)
	public void deleteContents(Long categoryId){
		//contentService.deleteContents(categoryId);
		System.out.println("删除成功......");
	}
	
//	
//	/**
//	 * 
//	 *  1:：有什么开发部不利于维护的代码
//	 *  2: 有没有更好的解决方案，
//	 *  3： redis可靠吗？---高并发
//	 *  
//	 * 根据分类id查询对应的轮展数据信息
//	 * 方法名：findContents<br/>
//	 * 创建人：xuchengfeifei <br/>
//	 * 时间：2019年3月7日-下午9:34:06 <br/>
//	 * 手机/微信:15074816437<br/>
//	 * @param categoryId
//	 * @param pageNo
//	 * @param pageSize
//	 * @return List<Content><br/>
//	 * @exception <br/>
//	 * @since  1.0.0<br/>
//	 */
//	public List<Content> findContents(Long categoryId,int pageNo,int pageSize){
//		try {
//			if(categoryId == null)return null;
//			// 1 : 先到缓存中去查询一次，看是否有轮播图相关数据
//			List<Content> contents  = redisService.getList(BannerKey.banners, "findContents", Content.class);
//			// 2： 如果缓存中有数据
//			if(contents!=null && contents.size()>0) {
//				log.info("------------------------进入缓存了.数据是:{}",contents);
//				//4 : 将缓存中的数据，json转换list
//				return contents;
//			}else {
//				log.info("------------------------进入数据库:{，查询放入缓存中}",contents);
//				// 查询数据
//				contents = contentService.findContentsByCategoryId(categoryId, pageNo, pageSize);
//				//3: 放入缓存中---string contents 是一个集合对象
//				redisService.set(BannerKey.banners,"findContents",contents);
//			}
//			return contents;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
}
