package org.dzq.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.dzq.springbootmybatis.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where username=#{username}")
	Users selectUserByName(@Param("username")String username);
	
	@Insert("insert into users(username,password) values(#{username},#{password})")
	int addUser(@Param("username")String username,@Param("password")String password);
	
	@Select("select * from users")
	List<Users> selectAllUser();
}
