package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestAddMultiplestudents {
	public static void main(String[] args) {
		
		ArrayList<Student> al = new ArrayList();
		Student s1 = new Student();
		s1.setId(21);
		s1.setName("Sarthak");
		s1.setEmail("sarthak2180@mail.com");

		Student s2 = new Student();
		s2.setId(250);
		s2.setName("sagar2515");
		s2.setEmail("sagar2515@mail.com");

		Student s3 = new Student();
		s3.setId(40);
		s3.setName("Hitman");
		s3.setEmail("Hitman45g@mail.com");
		al.add(s1);
		al.add(s2);
		al.add(s3);

		StudentDao studentDao = new StudentDao();
		studentDao.addMultipleStudents(al);

	}

}
