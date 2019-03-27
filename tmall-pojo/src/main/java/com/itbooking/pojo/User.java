package com.itbooking.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User  implements Serializable{
	
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
    private String sourceType;
    private String nickName;
    private String name;
    private String status;
    private String headPic;
    private String qq;
    private Float accountBalance;
    private String isMobileCheck;
    private String isEmailCheck;
    private String sex;
    private Integer userLevel;
    private Integer points;
    private Integer experienceValue;
    private Date birthday;
    private Date lastLoginTime;
    
}