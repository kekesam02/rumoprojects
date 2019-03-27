package com.itbooking.service.user.item;

import com.itbooking.pojo.Item;
import com.itbooking.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements  ItemService {


    @Autowired
    private MQItemProducer mqItemProducer;

    // 保存商品
    public int saveItem(Item item){
        item.setId(536563L);
        String json = JsonUtil.obj2String(item);
        System.out.println("保存商品是："+json+"成功!!!!");

        // 发送消息
        mqItemProducer.staticIndexCacheSend(json);
        return 1;
    }

    // 修改商品
    public int updateItem(Item item){
        String json = JsonUtil.obj2String(item);
        System.out.println("修改商品是："+json+"成功!!!!");

        // 发送消息
        mqItemProducer.staticIndexCacheSendUpdate(json);
        return 1;
    }

    // 删除商品
    public int delItemById(Long itemId){
        System.out.println("删除商品是："+itemId+"成功!!!!");

        String id = String.valueOf(itemId);
        // 发送消息
        mqItemProducer.staticIndexCacheSenddelete(id);
        return 1;
    }
}
