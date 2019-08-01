package org.dzq.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages="org.dzq")
@MapperScan("org.dzq.springbootmybatis.mapper")
@EnableCaching//使用redis要先开启缓存
public class SpringbootmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmybatisApplication.class, args);
	}

}
