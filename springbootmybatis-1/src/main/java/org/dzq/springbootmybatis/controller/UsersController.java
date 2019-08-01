package org.dzq.springbootmybatis.controller;

import java.util.List;

import org.dzq.springbootmybatis.pojo.Users;
import org.dzq.springbootmybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/selectUser")
	@ResponseBody
	public Users selectUser(String username) {
		Users user = usersService.selectUser(username);
		return user;
	}
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser() {
		Users user=new Users();
		user.setUsername("dzq");
		user.setPassword("123456");
		usersService.addUser(user);
		return "ok!";
	}
	
	@RequestMapping("/getUserList/{page}/{rows}")
	@ResponseBody
	public List<Users> getUserList(@PathVariable int page,@PathVariable int rows) {
		List<Users> UserList = usersService.selectAllUser(page, rows);
		return UserList;
	}
	
	@RequestMapping("/thymeleaftest1")
	public String thymeleaftest1(Model model) {
		model.addAttribute("word","单词");
		return "thymeleaf";
	}
}
