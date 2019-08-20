package com.wwj.service;

import java.util.List;

import com.wwj.model.Person;

public interface RedisService {

			/**
			 * 获取用户的数量
			 * @return
			 */
			Integer  getPersonCount();
			
			/**
			 * 获取所有的用户信息
			 * @return
			 */
			List<Person> getPersons();
			
			/**
			 * 根据id获取用户的信息
			 * @param id
			 * @return
			 */
			Person getPersonById(Integer  id);
			/**
			 * 保存用户信息
			 * @param name
			 * @return
			 */
			int savePerson (String name);
}
