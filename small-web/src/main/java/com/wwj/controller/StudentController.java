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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Controller
public class StudentController {

	@Autowired
	 private  StudentService  studentService;
	
	@Autowired
	private  TXService  txService;
	
	@RequestMapping("/select")
	@ResponseBody
	@ApiOperation(value="查询所有用户信息",httpMethod="POST")
	public List<Student>  a1(){
		List<Student> students = studentService.getAllStudent();
		return students;
	}
	
	@RequestMapping("/select1")
	@ResponseBody
	@ApiOperation(value="分页查询所有用户信息",httpMethod="POST") 
	public List<Student>  a11(){
		PageHelper.startPage(2, 3);
		List<Student> students = studentService.getAllStudent();
		PageInfo<Student> pi = new PageInfo<>(students);
		return students;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperation(value="添加学生信息",httpMethod="POST") 
	public Map<String,String>  a2(Student s){
		Map<String,String> map = new HashMap<>();
		int i = studentService.addStudent(s);
		map.put("code", "200");
		return map;
	}
	@RequestMapping("/update")
	@ResponseBody
	@ApiOperation(value="更新学生信息",httpMethod="POST") 
	public Map<String,String> a3(Student s){
		Map<String,String> map = new HashMap<>();
		int i= studentService.modifStudent(s);
		map.put("code", "200");
		return map;
	}
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperation(value="删除学生信息",httpMethod="POST") 
	public Map<String,String>  a4(@ApiParam(name = "sid", value = "学生编号", required = true)int sid){
		Map<String,String> map = new HashMap<>();
		int i  = studentService.removeStudentBySid(sid);
		map.put("code", "200");
		return map;
	}
	
	@RequestMapping("/tx")
	@ApiOperation(value="事务测试",httpMethod="POST") 
	public void  a4(){
			txService.Aservice();
	}
	
}
