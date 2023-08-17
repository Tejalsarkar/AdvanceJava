package in.co.rays.util;


	import java.beans.PropertyVetoException;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mchange.v2.c3p0.ComboPooledDataSource;

	public final class JDBCDataSource {

		// JDBC DataSource static object

		private static JDBCDataSource jds = null;

//		C3P0 database connection pool

		private ComboPooledDataSource ds = null;

		// Make dafault constructor private

		private JDBCDataSource() {

			try {
				// Create data source
				ds = new ComboPooledDataSource();

				// set DS Properties
				ds.setDriverClass("com.mysql.cj.jdbc.Driver");
				ds.setJdbcUrl("jdbc:mysql://localhost:3306/sachin");
				ds.setUser("root");
				ds.setPassword("ROOT");
				ds.setAcquireIncrement(5);
				ds.setInitialPoolSize(5);
				ds.setMaxPoolSize(50);

			} catch (PropertyVetoException e) {
				e.printStackTrace();

			}
		}

		// get singleton class instance
		public static JDBCDataSource getInstance() {

			if (jds == null) {

				jds = new JDBCDataSource();

			}
			return jds;
		}

		// gets connection from DCP

		public static Connection getConnection() {

			try {
				return getInstance().ds.getConnection();

			} catch (SQLException e) {
				return null;
			}

		}
		// Close connection

		public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {

			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		// Close Connection
		public static void closeConnection(Connection conn, Statement stmt) {

			closeConnection(conn, stmt, null);

		}

		// Close connection
		public static void closeConnection(Connection conn) {

			closeConnection(conn, null, null);
		}

	}



