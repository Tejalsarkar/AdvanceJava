package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import in.co.rays.util.JDBCDataSource;

public class TestAdd {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");

			 //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");


	         Connection conn1 = JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);

			Statement stat = conn.createStatement();

			int i = stat.executeUpdate("insert into marksheet values(21,'Sachin',101,25,45,43)");
			i = stat.executeUpdate("insert into marksheet values(22,'Sachin',101,25,45,43)");
			i = stat.executeUpdate("insert into marksheet values(22,'Sachin',101,25,45,43)");
			i = stat.executeUpdate("insert into marksheet values(23,'Sachin',101,25,45,43)");

			conn.commit();

		} catch (Exception e) {
			System.out.println("Data Inserted = " + e);
			
			conn.rollback();

			

		}
	}

}
