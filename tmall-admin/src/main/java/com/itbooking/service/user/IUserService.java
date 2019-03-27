package com.itbooking.service.user;

import com.itbooking.pojo.User;
import com.itbooking.vo.Params;

import java.util.Map;

public interface IUserService {
	
	/**
	 * 
	 *  保存用户管理
	 * 方法名：saveUser<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2018年9月26日-下午7:11:44 <br/>
	 * 手机:1564545646464<br/>
	 * @param user
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User saveUser(User user);
	
	/**
	 * 
	 * (修改用户管理)<br/>
	 * 方法名：updateUser<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月26日 14:27:59 <br/>
	 * 手机:1564545646464<br/>
	 * @param user
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int updateUser(User user);
	
	/**
	 * 
	 * (根据id删除用户管理)<br/>
	 * 方法名：deleteUserById<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月26日 14:27:59 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int deleteUserById(Long id);
	
	/**
	 * 
	 * (根据id获取用户管理)<br/>
	 * 方法名：getUserById<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月26日 14:27:59 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User getUserById(Long id);
	
	/**
	 * 
	 * (查询所有的用户管理)<br/>
	 * 方法名：queryUserAll<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2019年03月26日 14:27:59 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Map<String,Object> queryUserAll(Params params);
}
