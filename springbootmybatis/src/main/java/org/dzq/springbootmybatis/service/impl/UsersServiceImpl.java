package org.dzq.springbootmybatis.service.impl;

import java.util.List;

import org.dzq.springbootmybatis.mapper.UsersMapper;
import org.dzq.springbootmybatis.pojo.Users;
import org.dzq.springbootmybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import redis.clients.jedis.JedisCluster;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Cacheable(value="myname")
	@Override
	public Users selectUser(String username) {
		System.out.println("从数据库中查询。。。");
		return usersMapper.selectUserByName(username);
	}

	@Override
	public int addUser(Users user) {
		int effectNum = usersMapper.addUser(user.getUsername(), user.getPassword());
		return effectNum;
	}

	@Override
	public List<Users> selectAllUser(int page, int rows) {
		PageHelper.startPage(page,rows);
		List<Users> UserList = usersMapper.selectAllUser();
		return UserList;
	}

	@Override
	public String findRedis() {
		jedisCluster.set("haha","kele");
		return jedisCluster.get("haha");
	}


	
}
