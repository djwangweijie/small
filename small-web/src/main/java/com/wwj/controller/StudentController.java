package com.wwj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwj.model.Student;
import com.wwj.service.StudentService;
import com.wwj.service.TXService;



@Controller
public class StudentController {

	@Autowired
	 private  StudentService  studentService;
	
	@Autowired
	private  TXService  txService;
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Student>  a1(){
		List<Student> students = studentService.getAllStudent();
		return students;
	}
	
	@RequestMapping("/select1")
	@ResponseBody
	public List<Student>  a11(){
		PageHelper.startPage(2, 3);
		List<Student> students = studentService.getAllStudent();
		PageInfo<Student> pi = new PageInfo<>(students);
		return students;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Map<String,String>  a2(Student s){
		Map<String,String> map = new HashMap<>();
		int i = studentService.addStudent(s);
		map.put("code", "200");
		return map;
	}
	@RequestMapping("/update")
	@ResponseBody
	public Map<String,String> a3(Student s){
		Map<String,String> map = new HashMap<>();
		int i= studentService.modifStudent(s);
		map.put("code", "200");
		return map;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,String>  a4(int sid){
		Map<String,String> map = new HashMap<>();
		int i  = studentService.removeStudentBySid(sid);
		map.put("code", "200");
		return map;
	}
	
	@RequestMapping("/tx")
	public void  a4(){
			txService.Aservice();
	}
	
}
