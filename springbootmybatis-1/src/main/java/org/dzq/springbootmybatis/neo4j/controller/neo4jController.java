package org.dzq.springbootmybatis.neo4j.controller;

import org.dzq.springbootmybatis.neo4j.pojo.UserNode;
import org.dzq.springbootmybatis.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class neo4jController {
	@Autowired
	private UserService userService;
	@RequestMapping("/saveUserNode")
	@ResponseBody
	public String saveUserNode() {
		UserNode userNode=new UserNode();
		userNode.setNodeId(1l);
		userNode.setUserId("23");
		userNode.setName("dzq");
		userNode.setAge(17);
		userService.addUserNode(userNode);
		return "success";
	}

}
