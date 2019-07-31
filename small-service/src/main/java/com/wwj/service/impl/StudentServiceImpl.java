package com.wwj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwj.mapper.StudentMapper;
import com.wwj.model.Student;
import com.wwj.service.StudentService;

@Service("studentService")
public class StudentServiceImpl  implements  StudentService{

	@Autowired
	private  StudentMapper  studentMapper;
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentMapper.selectAll();
	}
	@Override
	public int addStudent(Student s) {
		// TODO Auto-generated method stub
		return studentMapper.insertStudent(s);
	}
	@Override
	public int modifStudent(Student s) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(s);
	}
	@Override
	public int removeStudentBySid(int sid) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudentBySid(sid);
	}


}
