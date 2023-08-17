package in.co.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPreparedAdd {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
	
	PreparedStatement ps = conn.prepareStatement("insert into marksheet values(8,'rahul',107,77,67,44)");
	
	int i = ps.executeUpdate();
	
	System.out.println("Data inserted = " + i);
	
	
		
	}

}
