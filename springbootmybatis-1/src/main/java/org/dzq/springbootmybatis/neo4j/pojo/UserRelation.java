package org.dzq.springbootmybatis.neo4j.pojo;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
@RelationshipEntity(type="UserRelation")
public class UserRelation {
	@GraphId
	private Long id;
	@StartNode
	private UserNode startNode;
	@EndNode
	private UserNode endNode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserNode getStartNode() {
		return startNode;
	}
	public void setStartNode(UserNode startNode) {
		this.startNode = startNode;
	}
	public UserNode getEndNode() {
		return endNode;
	}
	public void setEndNode(UserNode endNode) {
		this.endNode = endNode;
	}
}
