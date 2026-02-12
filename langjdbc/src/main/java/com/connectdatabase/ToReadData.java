package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ToReadData {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/schol";
	String un="postgres";
	String pwd="1424";
	Scanner sc=new Scanner(System.in);
	try {
		Class.forName("org.postgresql.Driver");

		Connection connect = DriverManager.getConnection(url, un, pwd);

		String sql="insert into student values(?,?)";
		PreparedStatement pstm=connect.prepareStatement(sql);
		System.out.println("Enter Id:- ");
		int id=sc.nextInt();
		pstm.setInt(1, id);
		
		System.out.println("Enter name ");
		String name=sc.next();
		pstm.setString(2, "King");
		 
		pstm.execute();
		
	} catch (Exception e) {

		e.printStackTrace();
	}
}
}
