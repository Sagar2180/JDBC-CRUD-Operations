package com.jsp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
	String url="jdbc:mysql://localhost:3306/javabatch";
	String username="root";
	String password="root";
	 Connection connection=null;
	 
	 public Connection getConnection() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }try {
			 connection=DriverManager.getConnection(url,username,password);
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return connection;
	 }

}
