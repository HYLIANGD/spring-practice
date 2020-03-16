package com.hy.springpractice.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.hy.springpractice.model.City;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<Object, City> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, City> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<City> serializer = new Jackson2JsonRedisSerializer<City>(City.class);
		template.setDefaultSerializer(serializer);
		return template;
	}
	
	
	@Bean("cityCacheManager")
    public RedisCacheManager  cityCacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration rcc = RedisCacheConfiguration.defaultCacheConfig()
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        RedisCacheManager rcm = RedisCacheManager.builder(connectionFactory).cacheDefaults(rcc).build();
        return rcm;
    }
	
	
}
