package org.dzq.springbootmybatis.neo4j.service;

import org.dzq.springbootmybatis.neo4j.dao.UserRepository;
import org.dzq.springbootmybatis.neo4j.pojo.UserNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void addUserNode(UserNode userNode) {
		userRepository.addUserNodeList(userNode.getName(), userNode.getAge());
	}
}
