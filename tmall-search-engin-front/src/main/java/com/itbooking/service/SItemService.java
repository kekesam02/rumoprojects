package com.itbooking.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.itbooking.vo.SItem;

public interface SItemService {

    long count();

    SItem save(SItem SItem);

    void delete(SItem SItem);

    Iterable<SItem> getAll();

    List<SItem> getByName(String name);

    Page<SItem> pageQuery(Integer pageNo, Integer pageSize, String kw);
    
    Page<SItem> pageQueyAll(String keyword,int pageNo,int pageSize);

}