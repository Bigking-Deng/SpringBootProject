package com.bigking.springboot.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;


import java.util.HashSet;
import java.util.Set;

@Configuration
public class lettuceClusterConfig {

    @Value("${wap-live-quality.sj.redis.cluster.nodes}")
    private String sj_nodes;
    @Value("${wap-live-quality.sj.redis.cluster.pass}")
    private String sj_password;

    @Value("${wap-live-quality.redis.cluster.lettuce.pool.maxIdle}")
    private int maxIdle;
    @Value("${wap-live-quality.redis.cluster.lettuce.pool.minIdle}")
    private int minIdle;
    @Value("${wap-live-quality.redis.cluster.lettuce.pool.maxTotal}")
    private int maxTotal;
    @Value("${wap-live-quality.redis.cluster.lettuce.pool.maxActive}")
    private int maxActive;




    public RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        String[] hosts = sj_nodes.split(",");
        Set<RedisNode> nodeSet = new HashSet<>();
        for(String hostandport:hosts){
            String[] hp = hostandport.split(":");
            nodeSet.add(new RedisNode(hp[0], Integer.valueOf(hp[1])));
        }
        redisClusterConfiguration.setClusterNodes(nodeSet);
        redisClusterConfiguration.setPassword(sj_password);
        return redisClusterConfiguration;
    }


    @Bean(name = "lettuceConnectionFactory")
    public LettuceConnectionFactory lettuceConnectionFactory(){
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxActive);
        LettucePoolingClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(genericObjectPoolConfig)
                .build();
        return new LettuceConnectionFactory(this.redisClusterConfiguration(), lettuceClientConfiguration);

    }

    @Bean(name = "lettuceRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(@Qualifier("lettuceConnectionFactory") LettuceConnectionFactory lettuceConnectionFactory){
        return new StringRedisTemplate(lettuceConnectionFactory);
    }


}
