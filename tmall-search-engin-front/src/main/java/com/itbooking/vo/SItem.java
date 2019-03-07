package com.itbooking.vo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;

// indexName 索引库的名字
// 生成mapping的名字：http://127.0.0.1:9200/items/_mapping
// http://127.0.0.1:9200/索引名字/_mapping
// type 是表名,如果你不配置的话，那么久是当前的类名小写作为表命
@Document(indexName = "items", type = "sitem", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
@Mapping(mappingPath = "sitem_mapping.json")
public class SItem {

	public static final String IK_MAX_WORD = "ik_max_word";// 细粒度切分
	public static final String IK_SMART = "ik_smart";// 最小切分

	@Id
	private String id;
	@Field(analyzer = IK_SMART, store = true, searchAnalyzer = IK_SMART)
	private String title;
	@Field(analyzer = IK_SMART, store = true, searchAnalyzer = IK_SMART)
	private String sellPoint;
	@Field(store = true, index = false)
	private String img;
	@Field(store = true, index = false)
	private Float price;
	@Field(format = DateFormat.date_time, index = false, store = true)
	private Date date;
	@Field(store = false, index = false)
	private Integer status;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
