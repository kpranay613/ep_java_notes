package jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getDBConnection() {

		Connection conn = null;

		// step1 register driver class
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// get the connection

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "admin");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

}