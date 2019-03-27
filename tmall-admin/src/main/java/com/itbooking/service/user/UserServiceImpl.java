package com.itbooking.service.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itbooking.mapper.UserMapper;
import com.itbooking.pojo.User;
import com.itbooking.vo.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * todo:用户管理Service实现类
 * UserServiceImpl<br/>
 * 作者:xuchengfeifei<br/>
 * 创建时间：2019年03月26日 14:27:59 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
@Component
public class UserServiceImpl implements IUserService  {

	@Autowired
	private UserMapper userMapper;
	
	public Map<String, Object> queryUserAll(Params params){
		PageHelper.startPage(params.getPageNo(), params.getPageSize());
		List<User> users = userMapper.queryUserAll(params);
		PageInfo<User> pageInfo = new PageInfo<>(users);
		Map<String, Object> map = new HashMap<>();
		map.put("data",pageInfo);
		return map;
	}
	
	@Override
	public User saveUser(User user) {
		int count = userMapper.saveUser(user);
		return count >0 ? user : null;
	}

	
	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	
	@Override
	public int deleteUserById(Long id) {
		return userMapper.deleteUserById(id);
	}

	
	@Override
	public User getUserById(Long id) {
		User user = userMapper.getUserById(id);
		return user;
	}
	
	
}
