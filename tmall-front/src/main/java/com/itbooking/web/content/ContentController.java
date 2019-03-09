package com.itbooking.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itbooking.pojo.Content;
import com.itbooking.service.item.ContentDubboService;

@RestController
public class ContentController {
	
	@Autowired
	private ContentDubboService contentDubboService;
	
	@GetMapping("/findContents")
	public ResponseEntity<List<Content>> findContents(
			@RequestParam("cid")Long cid,
			@RequestParam(name="pageNo",required=false,defaultValue="1")int pageNo,
			@RequestParam(name="pageSize",required=false,defaultValue="10")int pageSize){
				
		try {
			List<Content> contents = contentDubboService.findContents(cid, pageNo, pageSize);
			return ResponseEntity.status(HttpStatus.OK).body(contents);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
//	@GetMapping("/deleteContents")
//	public String deleteContents() {
//		contentDubboService.deleteContents(1L);
//		return "success";
//	}
	
}
