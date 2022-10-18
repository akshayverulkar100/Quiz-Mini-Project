package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student 
{
	
	static int count=0;
	static String sqlAns;
	static String email;
	public void setstudentForm() throws SQLException
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("**Student Form**");
		
		System.out.println("Student Name: ");
		String Name=sc.next();
		
		System.out.println("Student City: ");
		String City=sc.next();
		
		System.out.println("Student Email Id: ");
		 email=sc.next();
		
		System.out.println("Student Phone Number: ");
		String MobileNo=sc.next();
		
		insertionQuery(Name,City,email,MobileNo);

		sc.close();
	}
	public static void insertionQuery(String Name,String City,String EmailId,String MobileNo) throws SQLException
	{
		
		Connection con= ConnectionTest.getConnectionDetails();
		PreparedStatement ps = con.prepareStatement("insert into studenttable(Name,City,EmailId,MobileNo)values(?,?,?,?)");
		ps.setString(1,Name);
		ps.setString(2,City);
		ps.setString(3,EmailId);
		ps.setString(4,MobileNo);
		
		ps.execute();
		System.out.println("Data Inserted Successfully. ");
		
		fetchQuestions();	
	}
	public static void fetchQuestions()
	{
		Connection con= ConnectionTest.getConnectionDetails();
		String sql="select Questions,OptionA,OptionB,OptionC,OptionD,Answer from que order by rand() ";
		try
		{
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				
				
				System.out.println(rs.getString(1)+ "\n" +rs.getString(2)+ "\n"+ rs.getString(3)+ "\n" +rs.getString(4)+"\n"+ rs.getString(5)+"\n");
				
				Scanner sc= new Scanner(System.in);
				System.out.println("Enter Your Answer: (A-D)");
				char n=sc.next().charAt(0);
				
				int store =Character.compare(n,rs.getString(6).charAt(0));
				if (store==0)
				{
					count++;
				}
				
			}
			PreparedStatement ps1 = con.prepareStatement("update studenttable set Score=?,Grade=? where EmailId=?");
			ps1.setInt(1, count);
			if(count>=8)
			{
				ps1.setString(2, "A");
				
			}
			else if((count<8)&&(count>=6))
			{
				
				ps1.setString(2, "B");
				
			}
			else if((count<6)&&(count>=4))
			{
				
				ps1.setString(2, "C");
				
			}
			else
			{
				
				ps1.setString(2, "D / Fail");
				
			}
			
			ps1.setString(3,email);
			ps1.execute();
			System.out.println("Data Inserted Successfully. ");
			System.out.println("Score:" +count);
			System.out.println();
			System.out.println("**Exam ENDED**");
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}