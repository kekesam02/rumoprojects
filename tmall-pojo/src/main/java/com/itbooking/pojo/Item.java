package com.itbooking.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Item  implements Serializable{
	
    private Long id;
    private String title;
    private String sellPoint;
    private Float price;
    private Integer stockCount;
    private Integer num;
    private String barcode;
    private String image;
    private Long categoryid;
    private String status;
    private Date createTime;
    private Date updateTime;
    private String itemSn;
    private Float costPirce;
    private Float marketPrice;
    private String isDefault;
    private Long goodsId;
    private String sellerId;
    private String cartThumbnail;
    private String category;
    private String brand;
    private String spec;
    private String seller;
    private String url;//静态化的url地址

}