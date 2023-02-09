package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestSave {
	public static void main(String[] args) {
		Student student=new Student();
		student.setId(2180);
		student.setName("sagar");
		student.setEmail("sagar@gmail.com");
		
		StudentDao studentdeo=new StudentDao();
		Student s1=studentdeo.savestudent(student);
		System.out.println(s1.getId()+" has beeen saved");
		
	}

}

