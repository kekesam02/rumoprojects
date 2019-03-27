package com.itbooking.service;

import com.itbooking.vo.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {

    long count();

    Item save(Item item);

    Item update(Item item);

    void deleteById(String id);

    Iterable<Item> getAll();

    List<Item> getByName(String name);

    Page<Item> pageQuery(Integer pageNo, Integer pageSize, String kw);
    
    Page<Item> pageQueyAll(String keyword, int pageNo, int pageSize);

}