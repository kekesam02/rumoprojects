package com.itbooking.web.item;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itbooking.pojo.Item;
import com.itbooking.service.item.ItemDubboService;
import com.itbooking.vo.Params;

@RestController
public class ItemController {

	
	@Autowired
	private ItemDubboService itemDubboService;
	
	
	//http://localhost:9200/getitem/536563
	@GetMapping("/getitem/{id}")
	public ResponseEntity<Item> getItem(@PathVariable("id")Long id){
		Item item = itemDubboService.getItem(id);
		if(item != null) {
			return ResponseEntity.status(HttpStatus.OK).body(item);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//alt+shift+l
	//http://localhost:9200/finditems
	@GetMapping("/finditems")
	public ResponseEntity<Map<String, Object>> finditems(Params params){
		Map<String, Object> data = itemDubboService.findItems(params);
		if(data != null) {
			return ResponseEntity.status(HttpStatus.OK).body(data);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
