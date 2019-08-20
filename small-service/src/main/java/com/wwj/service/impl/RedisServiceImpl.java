package com.wwj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wwj.mapper.PersonMapper;
import com.wwj.model.Person;
import com.wwj.service.RedisService;

@Service("redisService")
public class RedisServiceImpl  implements  RedisService{
	
	@Autowired
	private  PersonMapper  personMapper;

	@Override
	public Integer getPersonCount() {
		// TODO Auto-generated method stub
		return personMapper.selectCountOfPerson();
	}

	@Cacheable(value="getPersons")
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personMapper.selectPersons();
	}

	
	@Cacheable(value="getPersonById",key="'getPersonById_'+#id")
	@Override
	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		return personMapper.selectPersonById(id);
	}

	@CacheEvict(value="getPersons",allEntries=true)
	@Override
	public int savePerson(String name) {
		// TODO Auto-generated method stub
		return personMapper.insertPerson(name);
	}

}
