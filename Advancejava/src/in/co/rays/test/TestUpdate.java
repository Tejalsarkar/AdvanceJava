package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
		  
		  Statement stat = conn.createStatement();
		  
		  int i = stat.executeUpdate(" update marksheet set name = 'Shubham jat' where id = 1");
		  
		  System.out.println("Data update = " + i);
		  
	}

}
