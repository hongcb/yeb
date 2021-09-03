package com.xxxx.server.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 * @author hongcb
 * @version 1.0
 * @date 2021/9/3 17:01
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory){
        //为string类型key设置序列器
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        //为string类型value设置序列器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //为hash类型key设置序列器
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //为hash类型value设置序列器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //设置工厂
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
