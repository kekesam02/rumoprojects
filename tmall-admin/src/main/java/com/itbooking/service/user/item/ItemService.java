package com.itbooking.service.user.item;

import com.itbooking.pojo.Item;

public interface ItemService {

    // 保存商品
    public int saveItem(Item item);
    // 修改商品
    public int updateItem(Item item);
    // 删除商品
    public int delItemById(Long itemId);
}
