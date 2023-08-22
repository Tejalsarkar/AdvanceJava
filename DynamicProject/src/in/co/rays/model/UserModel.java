package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {
		int Pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");

	//	Connection cn = JDBCDataSource.getConnection();
		PreparedStatement ps = cn.prepareStatement("select max(id) from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Pk = rs.getInt(1);
		}

		return Pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");
		PreparedStatement ps = cn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		// ps.setInt(1,bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
     	ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
    	ps.setString(7, bean.getAddress());

    	
		int i = ps.executeUpdate();

		System.out.println("Data inserted " + i);
	}

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");
		PreparedStatement ps = cn.prepareStatement("update user set first_name =?,last_name = ?,login_id = ?,password = ?,dob = ?,address = ? where id = ?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
	   ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Data updated " + i);

	}

	public UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");
		PreparedStatement ps = con.prepareStatement("select * from user where id =?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		

		}
		return bean;

	}
	
	
	

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" and first_Name like  '" + bean.getFirstName() + "%'");

			}
			if (bean.getId() != 0 && bean.getId() > 0) {

				sql.append(" and id = " + bean.getId());

			}
			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {

				sql.append(" and Login_Id like '" + bean.getLoginId() + "%'");
			}

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {

				sql.append(" and Dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");

			}
			if (bean.getAddress() != null && bean.getAddress().length()>0) {
				sql.append(" and address like '" + bean.getAddress() + "%'");
			}
				
				
		
		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + " , " + pageSize);
		}


		System.out.println(sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

			list.add(bean);

		}

		return list;

	}
	
	public UserBean findByloginId(String loginId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");
		PreparedStatement ps = con.prepareStatement("select * from user where login_id =?");

		ps.setString(1, loginId);
		

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		

		}
		return bean;

	}
	
	public UserBean authenticate(String loginId,String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sachin", "root", "ROOT");
		PreparedStatement ps = con.prepareStatement("select * from user where login_id =? and password =?");

		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		

		}
		return bean;

	}
public void delete(int id) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement ps = con.prepareStatement("Delete from user where id =?");
		
		ps.setInt(1, id);
		
		int i  = ps.executeUpdate();
		 System.out.println("Data Deleted = "+i);
		
}	
}