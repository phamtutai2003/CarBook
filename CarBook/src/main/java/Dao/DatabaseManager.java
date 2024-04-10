package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	private static final String URL ="jdbc:mysql://localhost:3307/carbook";
	private static final String USER="root";
	private static final String PASSWORD="1234";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
		 e.printStackTrace();
		 
		}
	}
	public static Connection getConnection( ) throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
		
	}
}
