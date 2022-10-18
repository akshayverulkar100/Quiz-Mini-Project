package com.student;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	public void menu() throws SQLException
	{
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t"+"Start QUIZ "+"\n");
		System.out.println("\t"+"Are You A ? "+"\n");
		System.out.println("\t"+"1. Teacher. ");
		System.out.println("\t"+"2. Student. ");
		Teacher t= new Teacher();
		Student s=new Student();
		
		n=sc.nextInt();
		switch(n)
		{
			case 1: System.out.println("**WELCOME**");
					t.teacherLogin();
					
					break;
			case 2: System.out.println("**Welcome**");
					s.setstudentForm();
					break;
			default: System.out.println("Invalid Input");
		}
	}
	
	public static void main(String [] args) throws SQLException
	{
		Menu mn = new Menu();
		mn.menu();
	}

}