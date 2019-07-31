package com.wwj.mapper;

import java.util.List;

import com.wwj.model.Student;

public interface StudentMapper {

	/**
	 * 查询所有学生信息
	 * @return  学生的全信息
	 */
	List<Student> selectAll();
	
	int insertStudent(Student s);
	
	int updateStudent(Student s);
	
	int deleteStudentBySid(int sid);
	
	void tx1(Student s);
	void tx2(int sid);
}
