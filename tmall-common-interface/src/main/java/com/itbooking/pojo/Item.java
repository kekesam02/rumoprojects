package com.itbooking.pojo;

import java.util.Date;
import java.io.Serializable;

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
    
    public Item() {
        super();
    }
    

	public Item(Long id, String title, String sellPoint, Float price, Integer stockCount, Integer num, String barcode,
			String image, Long categoryid, String status, Date createTime, Date updateTime, String itemSn,
			Float costPirce, Float marketPrice, String isDefault, Long goodsId, String sellerId, String cartThumbnail,
			String category, String brand, String spec, String seller, String url) {
		super();
		this.id = id;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.stockCount = stockCount;
		this.num = num;
		this.barcode = barcode;
		this.image = image;
		this.categoryid = categoryid;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.itemSn = itemSn;
		this.costPirce = costPirce;
		this.marketPrice = marketPrice;
		this.isDefault = isDefault;
		this.goodsId = goodsId;
		this.sellerId = sellerId;
		this.cartThumbnail = cartThumbnail;
		this.category = category;
		this.brand = brand;
		this.spec = spec;
		this.seller = seller;
		this.url = url;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getItemSn() {
		return itemSn;
	}

	public void setItemSn(String itemSn) {
		this.itemSn = itemSn;
	}

	public Float getCostPirce() {
		return costPirce;
	}

	public void setCostPirce(Float costPirce) {
		this.costPirce = costPirce;
	}

	public Float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCartThumbnail() {
		return cartThumbnail;
	}

	public void setCartThumbnail(String cartThumbnail) {
		this.cartThumbnail = cartThumbnail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
	
}