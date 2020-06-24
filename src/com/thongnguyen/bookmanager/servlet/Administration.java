package com.thongnguyen.bookmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thongnguyen.bookmanager.bo.Book;
import com.thongnguyen.bookmanager.dao.BookDAO;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/administration")
public class Administration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// MODEL
		BookDAO bookDAO = new BookDAO();
		ArrayList<Book> bookList = bookDAO.getAllBook();
		
		request.setAttribute("books", bookList);
		
		// VIEW
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/administration.jsp");       
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
