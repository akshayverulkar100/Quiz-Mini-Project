package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	public static Connection getConnectionDetails() 
	{
		Connection connection = null;
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_student", "root", "root");			
		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
			System.out.println("Connection Done");
			return connection;
		
	}

}