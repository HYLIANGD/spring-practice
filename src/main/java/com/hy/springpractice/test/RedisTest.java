package com.hy.springpractice.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.hy.springpractice.model.City;
import com.hy.springpractice.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate<Object, City> cityRedisTemplate;
	
	@Autowired
	private CityService cityService;
	
	@Test
	public void test() {
		System.out.println("Starting");
		stringRedisTemplate.opsForValue().append("java", "test");
		System.out.println("finished");
	}
	
	@Test
	public void test2() {
		System.out.println("Starting");
		cityRedisTemplate.opsForValue().set("javaObj", cityService.getCity(2l));
		System.out.println("finished");
	}
	
	
	
	
}
