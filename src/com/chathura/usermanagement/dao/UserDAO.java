package com.chathura.usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chathura.usermanagement.model.User;


public class UserDAO {
	
	private static final String CREATE_USER = "insert into user(name, email,country) values(?,?,?)";
	private static final String SELECT_USER_BY_ID = "select * from user where id=?";
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String UPDATE_USER = "update user set name=?, email=?, country=? where id=?";
	private static final String DELETE_USER = "delete from user where id=?";

	//insert user
	public void createUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			con = DbConnect.getConnection();
			ps = con.prepareStatement(CREATE_USER);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// select all users
	public List<User> getAllUsers(){
		
		List<User> users = new ArrayList<User>();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DbConnect.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(SELECT_ALL_USERS);
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(st!=null)
					st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	
	
	// select user by id
	public User getUserBuId (int id) {
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DbConnect.getConnection();
			ps = con.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getInt(1) ,rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	//update user
	public void updateUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbConnect.getConnection();
			ps = con.prepareStatement(UPDATE_USER);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.setInt(4, user.getId());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//delete user
	public void deleteUser(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbConnect.getConnection();
			ps = con.prepareStatement(DELETE_USER);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
