package com.wwj.mapper;

import java.util.List;

import com.wwj.model.Person;

public interface PersonMapper {

	/**
	 * 查询用户数量
	 * @return
	 */
	Integer  selectCountOfPerson();
	
	List<Person>  selectPersons();
	
	Person selectPersonById(Integer  id);
	
	int  insertPerson(String name);
}
