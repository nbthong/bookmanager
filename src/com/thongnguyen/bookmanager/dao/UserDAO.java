package com.thongnguyen.bookmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thongnguyen.bookmanager.bo.Book;
import com.thongnguyen.bookmanager.bo.User;
import com.thongnguyen.bookmanager.dbconnection.ConnectionFactory;

public class UserDAO {
	
	public User findByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE username = '"
					+ username + "' and password = '"
					+ password + "'";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} 
		return null;
	}
	
	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));		
		user.setUsername(rs.getString(2));		
		user.setPassword(rs.getString(3));		
		user.setRole(rs.getString(4));	
		return user;
	}
}
