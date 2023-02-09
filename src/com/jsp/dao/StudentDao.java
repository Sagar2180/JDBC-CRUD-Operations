package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;


public class StudentDao {
	HelperClass helperclass=new HelperClass();
	
	PreparedStatement prepareStatement =null;
	Connection connection=helperclass.getConnection();
	
	public Student savestudent(Student student) {
	//	Connection connection=helperclass.getConnection();
		String sql="INSERT INTO STUDENT VALUES(?,?,?)";
		
		try {
		    prepareStatement=connection.prepareStatement(sql);
			prepareStatement.setInt(1, student.getId());
			prepareStatement.setString(2, student.getName());
			prepareStatement.setString(3, student.getEmail());
			
			prepareStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	return student;	
	}
	
	public Student deleteStudentById(Student student) {
		String sql = "DELETE FROM STUDENT WHERE ID=?";

		try {
			prepareStatement= connection.prepareStatement(sql);
			prepareStatement.setInt(1, student.getId());

			prepareStatement.executeUpdate();

			System.out.println("Data is sucessfully deleted");

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection closed ");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return student;
	}
	
	public Student updateStudentById(Student student) {
		String sql = "UPDATE STUDENT SET NAME='DAVID' WHERE ID=?";
		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, student.getId());

			prepareStatement.executeUpdate();

			System.out.println("Data is sucessfully updated...");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return student;
	}
	
	public void showStudents(String sql) {

		try {
			prepareStatement = connection.prepareStatement(sql);
			ResultSet resultset = prepareStatement.executeQuery();

			while (resultset.next()) {
				System.out.println(resultset.getInt(1) + "--" + resultset.getString(2) + "--" + resultset.getString(3));
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Student> addMultipleStudents(List<Student> students) {

		Connection connection = helperclass.getConnection();
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			for (Student s : students) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				preparedStatement.addBatch();

			}
			preparedStatement.executeBatch();

			System.out.println("all data are added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return students;
	}

}



