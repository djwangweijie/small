package com.wwj.studentTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wwj.model.Student;
import com.wwj.service.StudentService;




public class StudentTest {
	
    private ApplicationContext ac = null;
    private StudentService studentService = null;
    @org.junit.Before
    public void Before(){
        ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
        studentService = (StudentService) ac.getBean("studentService");
    }

	
	@Test
    public void testadd() throws ParseException{
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sf.format(new Date());
		Date parse = sf.parse(format);
    		Student s = new Student();
    		s.setSname("wwj");
    		s.setBir(parse);
    		studentService.addStudent(s);
    		
    }
}
