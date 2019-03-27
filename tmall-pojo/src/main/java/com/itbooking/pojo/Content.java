package com.itbooking.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Content  implements Serializable{
	
    private Long id;
    private Long categoryId;
    private String title;
    private String url;
    private String pic;
    private String status;
    private Integer sortOrder;
}