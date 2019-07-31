package com.wwj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wwj.mapper.StudentMapper;
import com.wwj.model.Student;
import com.wwj.service.TXService;

@Service("txService")
public class TXserviceImpl  implements  TXService{

	@Autowired
	private  StudentMapper studentMapper;
	
	@Autowired
	private   TXService   txService;
	@Override
	@Transactional
	public void Aservice() {
		// TODO Auto-generated method stub
		Student s= new Student();
		s.setSid(9);
		s.setSname("5");	
		studentMapper.tx1(s);
		txService.Bservice();
	}

	@Override
	public void Bservice() {
		// TODO Auto-generated method stub
		studentMapper.tx2(8);
	}

}
