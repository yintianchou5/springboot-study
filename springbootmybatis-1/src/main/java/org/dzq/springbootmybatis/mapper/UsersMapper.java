package org.dzq.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.dzq.springbootmybatis.pojo.Users;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersMapper {
	Users selectUserByName(@Param("username")String username);
	
	int addUser(@Param("username")String username,@Param("password")String password);
	
	List<Users> selectAllUser();
}
