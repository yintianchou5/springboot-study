package org.dzq.springbootmybatis.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	@Value("${spring.redis.cluster.nodes}")
	private String redisNodes;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.pool.max-wait}")
	private long maxWaitMillis;
	@Value("${spring.redis.commandTimeout}")
	private int commandTimeout;
//	@Value("${spring.redis.password}")
//	private String password;

	@Bean
	public JedisCluster getJedisCluster() {
		String[] redisnodes=redisNodes.split(",");
		Set<HostAndPort> nodes=new HashSet<>();
		for(String node:redisnodes) {
			String[] arr=node.split(":");
			HostAndPort hostAndPort=new HostAndPort(arr[0],Integer.parseInt(arr[1]));
			nodes.add(hostAndPort);
		}
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		//创建集群对象。没有密码的请使用这一个
        JedisCluster jedisCluster = new JedisCluster(nodes,commandTimeout); 
        //JedisCluster jedisCluster = new JedisCluster(nodes,commandTimeout,commandTimeout,5,password, jedisPoolConfig); 
       //有密码的请使用这一个。 我这里是redis有密码的所以我使用的这一个
		return jedisCluster;
	}
}
