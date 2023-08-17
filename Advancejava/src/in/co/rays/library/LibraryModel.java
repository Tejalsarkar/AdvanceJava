package in.co.rays.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.util.JDBCDataSource;

public class LibraryModel {
	
	public void add(librarybean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into library values(?,?,?,?,?)");
		
		ps.setInt(1,bean.getId() );
		ps.setString(2, bean.getStudent_name());
		ps.setInt(3, bean.getFees());
		ps.setInt(4, bean.getMobile_no());
		ps.setString(5, bean.getAddress());
		
		int i = ps.executeUpdate();
		
		System.out.println("Data inserted = " + i);
		
	}
	
	public void update(librarybean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(" Update library set student_name = ?,fees = ?,mobile_no = ?,address = ? where id = ?");
		
		ps.setString(1, bean.getStudent_name());
		ps.setInt(2, bean.getFees());
		ps.setInt(3, bean.getMobile_no());
		ps.setString(4, bean.getAddress());
		ps.setInt(5, bean.getId());
		
		int i = ps.executeUpdate();
		
		System.out.println(" Data Updated = " + i);
	}
	
	

}
