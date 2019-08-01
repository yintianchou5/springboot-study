package org.dzq.springbootmybatis.neo4j.dao;

import java.util.List;

import org.dzq.springbootmybatis.neo4j.pojo.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
@Component
public interface UserRepository extends GraphRepository<UserNode>{
	@Query("match (n:User) return n")
	List<UserNode> getUserNodeList();
	
	@Query("create (n:User{age:{age},name:{name}}) return n")
	List<UserNode> addUserNodeList(@Param("name") String name,@Param("age") int age);
}
