package com.itbooking.web;

import com.itbooking.pojo.Item;
import com.itbooking.service.user.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author 徐柯老师
 * @Description
 * @Tel/微信：15074816437
 * @Version 1.0
 **/
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item/save")
    public String save(){
        Item item = new Item();
        item.setTitle("new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待");
        item.setSellPoint("清仓！仅北京，武汉仓有货！");
        item.setPrice(3324.33f);
        item.setStockCount(1);
        item.setNum(99999);
        item.setBarcode("S222");
        item.setImage("http://img12.360buyimg.com/n1/s450x450_jfs/t3034/299/2060854617/119711/577e85cb/57d11b6cN1fd1194d.jpg");
        item.setCategoryid(560L);
        item.setStatus("1");
        item.setCreateTime(new Date());
        item.setItemSn("122");
        item.setCostPirce(342.3f);
        item.setMarketPrice(45343.3f);
        item.setIsDefault("1");
        item.setGoodsId(123L);
        item.setSellerId("23");
        item.setCartThumbnail("aaa.jpg");
        item.setCategory("手机");
        item.setBrand("阿尔卡特");
        item.setSpec("{\"机身内存\":\"16G\",\"网络\":\"联通3G\"}");
        item.setSeller("阿尔卡特");
        item.setUrl(null);
        itemService.saveItem(item);
        return "success";
    }


    @GetMapping("/item/update")
    public String update(){
        Item item = new Item();
        item.setId(536563L);
        item.setTitle("update---- - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待");
        item.setSellPoint("清仓！仅北京，武汉仓有货！");
        item.setPrice(3324.33f);
        item.setStockCount(1);
        item.setNum(99999);
        item.setBarcode("S222");
        item.setImage("http://img12.360buyimg.com/n1/s450x450_jfs/t3034/299/2060854617/119711/577e85cb/57d11b6cN1fd1194d.jpg");
        item.setCategoryid(560L);
        item.setStatus("1");
        item.setCreateTime(new Date());
        item.setItemSn("122");
        item.setCostPirce(342.3f);
        item.setMarketPrice(45343.3f);
        item.setIsDefault("1");
        item.setGoodsId(123L);
        item.setSellerId("23");
        item.setCartThumbnail("aaa.jpg");
        item.setCategory("手机");
        item.setBrand("阿尔卡特");
        item.setSpec("{\"机身内存\":\"16G\",\"网络\":\"联通3G\"}");
        item.setSeller("阿尔卡特");
        item.setUrl(null);
        itemService.updateItem(item);
        return "success";
    }

    @GetMapping("/item/delete")
    public String delete(){
        itemService.delItemById(536563L);
        return "success";
    }

}
