package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.student.ConnectionTest;

public class Teacher {
	public void teacherLogin()
	{
		String id="teacher";
		String password= "pass@123";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Login ID: ");
		String Id=sc.next();
		
		System.out.println("Password: ");
		String pass=sc.next();
		
		
		if((id.equals(Id)) && (password.equals(pass)))
		{
			
			System.out.println("**Login Successful**");
		}
		else
		{
			System.out.println("**Id or Password Wrong**");
		}
			System.out.println("For Student information press 1 ");
			System.out.println("For Question press 2 ");
			int n=sc.nextInt();
			if(n==1) {
				getstudenttable();
			}
			else if(n==2) {
				getque();
				
			}
			
				
	}
	
	public static void getstudenttable()
	{
		Connection con= ConnectionTest.getConnectionDetails();
		String sql="select Id,Name,City,emailid,MobileNo,Score,Grade from studenttable order by Score ";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs1= st.executeQuery(sql);
			
			while(rs1.next())
			{
				
				System.out.println(" Id- " +rs1.getString(1)+ ", name- "+rs1.getString(2)+  ", city- "+rs1.getString(3)+
						", EmailId- " +rs1.getString(4)+ ", MobileNO -" +rs1.getString(5)+ ", Score- "+rs1.getString(6)+ ", Grade- "+rs1.getString(7));
				
			}
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}	
	public static void getque()
	{
		Connection con= ConnectionTest.getConnectionDetails();
		String sql="select Questions,OptionA,OptionB,OptionC,OptionD,Answer from question ";
		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs2= st.executeQuery(sql);
			
			while(rs2.next())
			{
				System.out.println("Question>>" +rs2.getString(1));
				System.out.println("Option A- " +rs2.getString(2));
				System.out.println("Option B- " +rs2.getString(3));
				System.out.println("Option C- " +rs2.getString(4));
				System.out.println("Option D- " +rs2.getString(5));
				System.out.println(" Answer->>" +rs2.getString(6));
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}

	
	