package com.thongnguyen.bookmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thongnguyen.bookmanager.bo.Book;
import com.thongnguyen.bookmanager.dao.BookDAO;
import com.thongnguyen.bookmanager.utils.FileUpdateUtil;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		// MODEL
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.findById(id);
		
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateBook.jsp");       
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET parameters
		request.setCharacterEncoding("UTF-8");
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		String name = (String) request.getParameter("name");
		String author = (String) request.getParameter("author");
		String publisher = (String) request.getParameter("publisher");
		String type = (String) request.getParameter("type");
		String language = (String) request.getParameter("language");
		String description = (String) request.getParameter("description");
		String quantityStr = (String) request.getParameter("quantity");
		
		int quantity = Integer.parseInt(quantityStr);
		
		String imagePath = FileUpdateUtil.saveImage(request);
		
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateBook(id, name, author, publisher, type, language, description, quantity, imagePath);
		
		response.sendRedirect(request.getContextPath() + "/administration");
	}

}
