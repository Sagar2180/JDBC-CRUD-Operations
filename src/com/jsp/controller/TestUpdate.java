package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestUpdate {
	public static void main(String[] args) {

		Student student = new Student();
		student.setId(169);

		StudentDao studentDao = new StudentDao();
		studentDao.updateStudentById(student);
	}

}
