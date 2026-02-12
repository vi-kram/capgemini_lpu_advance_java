package com.connectdatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SteptoConnectDataBase {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/schol";
        String un = "postgres";
        String pwd = "1424";

        try {
            // Load driver
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url,un,pwd);
            
            
            
//            String sql="insert into student values(5,'Amar','Q123@gmai.com','male')";
//            String sql = "DELETE FROM student WHERE id = 1";
            
            String sql = "UPDATE student SET email = 'Q123@gmail.com', gender = 'male' WHERE id = 2";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "amar123@gmail.com");
            ps.setString(2, "male");
            ps.setInt(3, 5);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record updated");
            
            //create querry
            Statement smt=connect.createStatement();
            //Execute querry
            smt.execute(sql);
            connect.close();
            System.out.println("data inserted");
            DriverManager.getConnection(url, un, pwd);

//            System.out.println("Connected successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
