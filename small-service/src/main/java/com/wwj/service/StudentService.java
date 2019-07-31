package com.wwj.service;

import java.util.List;

import com.wwj.model.Student;

public interface StudentService {

	/**
	 * 获取所有学生
	 * @return  学生的信息
	 */
	List<Student>  getAllStudent();
	
	int addStudent(Student s );
	int modifStudent(Student s);
	int removeStudentBySid(int sid);
}
