package com.wwj.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwj.model.Person;
import com.wwj.service.RedisService;

@Controller
public class RedisController {
	
	@Autowired
	private  RedisService  redisService;
	
	@Resource
    private RedisTemplate redisTemplate;
	
	@RequestMapping("/selectRedis1")
	@ResponseBody
	public String   selectRedis1(){
		String personCount = null;
		personCount= (String) redisTemplate.opsForValue().get("person_count");
		
		if(personCount == null){
    		//redis缓存中无数据，从数据库中查询，并放入redis缓存中，设置生存时间为1小时
    		personCount = Integer.toString(redisService.getPersonCount());
    		redisTemplate.opsForValue().set("person_count", personCount, 1, TimeUnit.HOURS);
    	} else {
    		System.out.println("从redis拿取数据");
    		personCount=  (String) redisTemplate.opsForValue().get("person_count");
    	}	
		return personCount;
	}
	
	
	@RequestMapping("/selectRedis2")
	@ResponseBody
	public List<Person>   selectRedis2(){
		return redisService.getPersons();
	}
	
	@RequestMapping("/selectRedis3")
	@ResponseBody
	public Person   selectRedis3(){
		return redisService.getPersonById(1);
		
	}
	
	@RequestMapping("/insertRedis1")
	@ResponseBody
	public String   insertRedis1(){
		String rs = String.valueOf(redisService.savePerson("xxx"));
		return rs;
		
	}

}
