package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
		  
		           Statement stat = conn.createStatement();
		           
//		            int i = stat.executeUpdate("Delete from marksheet where id = > 10");
		           int i = stat.executeUpdate("Drop table emp");  
		            System.out.println("Data Delete = " + i);
		
	}

}
