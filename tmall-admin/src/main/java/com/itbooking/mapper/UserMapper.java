package com.itbooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itbooking.pojo.User;
import com.itbooking.vo.Params;


/**
 * 
 * todo:用户管理
 * User<br/>
 * 创建人:xuchengfeifei<br/>
 * 时间：2019年03月26日 14:27:59 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface UserMapper {
	//添加
	public int saveUser(User user);
	//修改
	public int updateUser(User user);
	//删除
	public int deleteUserById(@Param("id") Long id);
	//查询单个
	public User getUserById(@Param("id") Long id);
	//查询所有
	public List<User> queryUserAll(Params params);
}