package com.thongnguyen.bookmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thongnguyen.bookmanager.bo.Book;
import com.thongnguyen.bookmanager.dbconnection.ConnectionFactory;

public class BookDAO {
	
	public void insertBook(String name, 
							String author, 
							String publisher, 
							String type,
							String language, 
							String description, 
							int quantity) {
		Connection connection = null;
		Statement statement = null;
		try {	
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO books (name,author,publisher,type,language,description,quantity)"
						+" VALUES ('" + name
						+ "','" + author
						+ "','" + publisher
						+ "','" + type
						+ "','" + language
						+ "','" + description
						+ "'," + quantity
						+ ");";
			System.out.println(sql);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void deleteBook(int id) {
		Connection connection = null;
		Statement statement = null;
		try {	
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM books WHERE id = " + id;
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public ArrayList<Book> searchByName(String textSearch){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		try {
			
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM books WHERE name = '" + textSearch + "'";
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				bookList.add(convertToBook(resultSet));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return bookList;
	}
	
	
	public ArrayList<Book> getAllBook(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		try {
			// search 
			//String search = "mat biec ";
			
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM books";
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				bookList.add(convertToBook(resultSet));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return bookList;
	}
	
	private static Book convertToBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		
		book.setId(rs.getInt(1));		
		book.setName(rs.getString(2));		
		book.setAuthor(rs.getString(3));		
		book.setPublisher(rs.getString(4));	
		book.setType(rs.getString(5));
		book.setLanguage(rs.getString(6));
		book.setDescription(rs.getString(7));
		book.setQuantity(rs.getInt(8));
		book.setImage(rs.getString(9));
		
		return book;
	}
}
