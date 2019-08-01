package org.dzq.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication(scanBasePackages="org.dzq")
@MapperScan("org.dzq.springbootmybatis.mapper")
@EnableNeo4jRepositories(basePackages="org.dzq.springbootmybatis.neo4j.dao")
@EntityScan(basePackages="org.dzq.springbootmybatis.neo4j.pojo")
public class Springbootmybatis1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootmybatis1Application.class, args);
	}

}
