package org.dzq.springbootmybatis.service;

import java.util.List;

import org.dzq.springbootmybatis.pojo.Users;

public interface UsersService {
	Users selectUser(String username);
	int addUser(Users user);
	List<Users> selectAllUser(int page,int rows);
	public String findRedis();
}
