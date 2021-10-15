package com.chathura.usermanagement.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/user_management_db","root","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
