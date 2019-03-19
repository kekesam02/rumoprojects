package com.itbooking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbooking.vo.Params;
import com.itbooking.pojo.Item;
import com.itbooking.service.item.IItemService;

/**
 * 
 * todo:商品管理Controller控制器类
 * ItemController<br/>
 * 作者:xuchengfeifei<br/>
 * 创建时间：2019年03月01日 16:47:08 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@GetMapping("/item")
	public String itemindex() {
		return "item/index";
	}

	/**
	 * 方法名：itemdetail<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@GetMapping("/item/{id}")
	public String itemdetail(@PathVariable("id") Long id,ModelMap map) {
		map.addAttribute("id", id);
		return "item/detail";
	}
	
	
	/**
	 * 模板方法，提供给分页使用
	 * 方法名：template<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08 <br/>
	 * 手机:15074816437<br/>
	 * @param params
	 * @param map
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@PostMapping("/item/template")
	public String template(Params params,ModelMap map) {
		Map<String,Object> data = itemService.queryItemAllPage(params);
		map.addAttribute("pages", data);
		return "item/template";
	}
	
	
	/**
	 * 根据id查询信息
	 * 方法名：getItem<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@GetMapping("/item/get/{id}")
	public Item getItem(@PathVariable("id") Long id) {
		return itemService.getItemById(id);
	}
	
	
	/**
	 * 保存
	 * 方法名：saveItem<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08<br/>
	 * 手机:15074816437<br/>
	 * @param itemVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/item/save")
	public Item saveItem( Item item) {
		return itemService.saveItem(item);
	}
	
	/**
	 * 修改
	 * 方法名：updateItem<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08 <br/>
	 * 手机:15074816437<br/>
	 * @param itemVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/item/update")
	public int updateItem(Item item) {
		return itemService.updateItem(item);
	}
	
	
	/**
	 * 删除
	 * 方法名：deleteItem<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2019年03月01日 16:47:08 <br/>
	 * 手机:15074816437<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@PostMapping("/item/delete/{id}")
	public int deleteItem(@PathVariable("id") Long id) {
		return itemService.deleteItemById(id);
	}
	
}
