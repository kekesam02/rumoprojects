package com.itbooking.pojo;

import java.io.Serializable;

public class Content  implements Serializable{
	
    private Long id;
    private Long categoryId;
    private String title;
    private String url;
    private String pic;
    private String status;
    private Integer sortOrder;
    
    public Content() {
        super();
    }
    
    public Content(Long id,Long categoryId,String title,String url,String pic,String status,Integer sortOrder) {
        super();
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.url = url;
        this.pic = pic;
        this.status = status;
        this.sortOrder = sortOrder;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
 	
 	public String toString(Long id,Long categoryId,String title,String url,String pic,String status,Integer sortOrder) {
        return "Content:【this.id:"+id+",this.categoryId:"+categoryId+",this.title:"+title+",this.url:"+url+",this.pic:"+pic+",this.status:"+status+",this.sortOrder:"+sortOrder+"】";
    }
    
    public static class ContentBuilder{
 	   
	    private Long id;
	    private Long categoryId;
	    private String title;
	    private String url;
	    private String pic;
	    private String status;
	    private Integer sortOrder;

 	    public String toString(){
 	    	 return "Content.ContentBuilder:【this.id:"+id+",this.categoryId:"+categoryId+",this.title:"+title+",this.url:"+url+",this.pic:"+pic+",this.status:"+status+",this.sortOrder:"+sortOrder+"】";
 	    }

 	    public Content build(){
 	      return new Content(id,categoryId,title,url,pic,status,sortOrder);
 	    }

 	    public ContentBuilder id(Long id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public ContentBuilder categoryId(Long categoryId){
 	      this.categoryId = categoryId;
 	      return this;
 	    }
 	    
 	    public ContentBuilder title(String title){
 	      this.title = title;
 	      return this;
 	    }
 	    
 	    public ContentBuilder url(String url){
 	      this.url = url;
 	      return this;
 	    }
 	    
 	    public ContentBuilder pic(String pic){
 	      this.pic = pic;
 	      return this;
 	    }
 	    
 	    public ContentBuilder status(String status){
 	      this.status = status;
 	      return this;
 	    }
 	    
 	    public ContentBuilder sortOrder(Integer sortOrder){
 	      this.sortOrder = sortOrder;
 	      return this;
 	    }
 	    
 	  }

 	  public static Content.ContentBuilder builder(){
 	    return new Content.ContentBuilder();
 	  }
}