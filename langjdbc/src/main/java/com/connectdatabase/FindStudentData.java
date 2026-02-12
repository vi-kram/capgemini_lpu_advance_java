package com.connectdatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindStudentData {
public static void main(String[] args) {
	
//	String url="jdbc:postgresql://localhost:5432/schol";
//	String un="postgres";
//	String pwd="1424";
//	try {
//		Class.forName("org.podtgresql.Driver");
//		Connection connect = DriverManager.getConnection(url,un,pwd);
//		Statement stmt=connect.createStatement();
//		String sql="select *from student";
//		ResultSet res=stmt.executeQuery(sql;)
//		smt.executeQuery(sql);
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	String url="jdbc:postgresql://localhost:5432/schol";
	String un="postgres";
	String pwd="1424";
	try {
		Class.forName("org.podtgresql.Driver");
		Connection connect = DriverManager.getConnection(url,un,pwd);
		Statement stmt=connect.createStatement();
		String sql="select *from Employee";
		ResultSet res=stmt.executeQuery(sql;)
		smt.executeQuery(sql);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
