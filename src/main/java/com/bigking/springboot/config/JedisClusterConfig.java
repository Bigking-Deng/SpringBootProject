package com.bigking.springboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class JedisClusterConfig {

    @Value("${wap-live-quality.sj.redis.cluster.nodes}")
    private String sj_nodes;
    @Value("${wap-live-quality.sj.redis.cluster.pass}")
    private String sj_password;
    @Value("${wap-live-quality.sj.redis.cluster.jedis.pool.connectionTimeout}")
    private String sj_connectionTimeout;
    @Value("${wap-live-quality.sj.redis.cluster.jedis.pool.maxIdle}")
    private int sj_maxIdle;
    @Value("${wap-live-quality.sj.redis.cluster.jedis.pool.minIdle}")
    private int sj_minIdle;
    @Value("${wap-live-quality.sj.redis.cluster.jedis.pool.maxTotal}")
    private int sj_maxTotal;
    @Value("${wap-live-quality.sj.redis.cluster.database}")
    private int sj_database;
    @Value("${wap-live-quality.sj.redis.cluster.jedis.pool.maxAttempts}")
    private int sj_maxAttempts;

    @Value("${wap-live-quality.tx.redis.cluster.nodes}")
    private String tx_nodes;
    @Value("${wap-live-quality.tx.redis.cluster.pass}")
    private String tx_password;
    @Value("${wap-live-quality.tx.redis.cluster.jedis.pool.connectionTimeout}")
    private String tx_connectionTimeout;
    @Value("${wap-live-quality.tx.redis.cluster.jedis.pool.maxIdle}")
    private int tx_maxIdle;
    @Value("${wap-live-quality.tx.redis.cluster.jedis.pool.minIdle}")
    private int tx_minIdle;
    @Value("${wap-live-quality.tx.redis.cluster.jedis.pool.maxTotal}")
    private int tx_maxTotal;
    @Value("${wap-live-quality.tx.redis.cluster.database}")
    private int tx_database;
    @Value("${wap-live-quality.tx.redis.cluster.jedis.pool.maxAttempts}")
    private int tx_maxAttempts;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(sj_maxIdle);
        config.setMinIdle(sj_minIdle);
        config.setMaxTotal(sj_maxTotal);
        return config;
    }

    @Bean(name = "jedisPoolConfig_tx")
    public JedisPoolConfig jedisPoolConfig_tx(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(tx_maxIdle);
        config.setMinIdle(tx_minIdle);
        config.setMaxTotal(tx_maxTotal);
        return config;
    }

    @Bean(name = "redisClusterConfiguration")
    @Primary
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

    @Bean(name = "redisClusterConfiguration_tx")
    public RedisClusterConfiguration redisClusterConfiguration_tx(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        String[] hosts = tx_nodes.split(",");
        Set<RedisNode> nodeSet = new HashSet<>();
        for(String hostandport:hosts){
            String[] hp = hostandport.split(":");
            nodeSet.add(new RedisNode(hp[0], Integer.valueOf(hp[1])));
        }
        redisClusterConfiguration.setClusterNodes(nodeSet);
        redisClusterConfiguration.setPassword(tx_password);
        return redisClusterConfiguration;
    }

    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory jedisConnectionFactory(
            @Qualifier("redisClusterConfiguration") RedisClusterConfiguration redisClusterConfiguration,
            @Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig
    ){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean(name = "jedisConnectionFactory_tx")
    public JedisConnectionFactory jedisConnectionFactory_tx(
            @Qualifier("redisClusterConfiguration_tx") RedisClusterConfiguration redisClusterConfiguration,
            @Qualifier("jedisPoolConfig_tx") JedisPoolConfig jedisPoolConfig
    ){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration, jedisPoolConfig);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    @Bean(name = "redisTemplate")
    @Primary
    public StringRedisTemplate stringRedisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory){
        return new StringRedisTemplate(jedisConnectionFactory);
    }

    @Bean(name = "redisTemplate_tx")
    public StringRedisTemplate stringRedisTemplateTX(@Qualifier("jedisConnectionFactory_tx") JedisConnectionFactory jedisConnectionFactory){
        return new StringRedisTemplate(jedisConnectionFactory);
    }

}
