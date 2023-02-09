package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestDelete {
	public static void main(String[] args) {

		Student student = new Student();
		student.setId(45);

		StudentDao studentDao = new StudentDao();
		studentDao.deleteStudentById(student);
	}

}
