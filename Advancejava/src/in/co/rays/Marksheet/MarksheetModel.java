package in.co.rays.Marksheet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;


public class MarksheetModel {
	public List search( MarksheetBean bean, int pageNo, int pageSize) throws Exception  {
		

		 Connection conn = JDBCDataSource.getConnection();
		
		//Class.forName("com.mysql.cj.jdbc.Driver");

		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append(" and name like '" + bean.getName() + "%'");

			}
			if (bean.getId() != 0 && bean.getId() > 0) {

				sql.append(" and id = " + bean.getId());

			}

			if (bean.getRoll_No() != 0 && bean.getRoll_No() > 0) {

				sql.append(" and roll_no = " + bean.getRoll_No());

			}
             if (bean.getPhysics() != 0 && bean.getPhysics() > 0) {
				
            	 sql.append(" and physics = " + bean.getPhysics());
            	 
			}
		}

		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + ", " + pageSize);

		}

		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRoll_No(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}

		return list;

	}



	public MarksheetBean findByRoll_No(int Roll_No) throws Exception{
	
	Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
	
	PreparedStatement ps =  conn.prepareStatement("select * from marksheet where Roll_No= ?");

	ps.setInt(1, Roll_No);
	
	ResultSet rs = ps.executeQuery();
	
	MarksheetBean bean = null;
	
	while (rs.next()) {
		
		
		bean.setId(rs.getInt(1));
		bean.setName(rs.getString(2));
		bean.setRoll_No(rs.getInt(3));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
		
		
	}
	
	
	return bean;
		
	
	
}
	
	 public  void update(MarksheetBean bean) throws Exception {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
			
			PreparedStatement ps =  conn.prepareStatement("update marksheet set name = ?,roll_number = ?,Physics = ?,Chemistry = ?,Maths = ? where id = ?");
			
		
		
		ps.setString(1,bean.getName());
		ps.setInt(2,bean.getRoll_No());
		ps.setInt(3,bean.getPhysics());
		ps.setInt(4,bean.getChemistry());
		ps.setInt(5,bean.getMaths());
		ps.setInt(6,bean.getId());
	
		int i = ps.executeUpdate();
		
		System.out.println("Data Updated  " + i);
		
	}
	 
 public  void add(MarksheetBean bean) throws Exception  {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin","root","ROOT");
		
		PreparedStatement ps =  conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		ps.setInt(1,bean.getId());
		ps.setString(2,bean.getName());
		ps.setInt(3,bean.getRoll_No());
		ps.setInt(4,bean.getPhysics());
		ps.setInt(5,bean.getChemistry());
		ps.setInt(6,bean.getMaths());
		
	
		int i = ps.executeUpdate();
		
		System.out.println("Data inserted  " + i);
		
 }		
     
	
}





