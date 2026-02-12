package com.connectdatabase;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;

	public class UseCrudOpr {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/schol";
		String un="postgres";
		String pwd="1424";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");

			Connection connect = DriverManager.getConnection(url, un, pwd);

			String sql="insert into employee values(?,?)";
			PreparedStatement pstm=connect.prepareStatement(sql);
			System.out.println("Enter eId:- ");
			int eid=sc.nextInt();
			pstm.setInt(1, eid);
			
			System.out.println("Enter ename ");
			String ename=sc.next();
			pstm.setString(2, "King");
			
			pstm.execute();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

}

