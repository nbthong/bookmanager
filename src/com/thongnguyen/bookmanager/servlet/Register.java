package com.thongnguyen.bookmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thongnguyen.bookmanager.dao.UserDAO;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REGISTER SERVLET CALLED");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");       
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		boolean isUsernameExists  = userDAO.isUsernameExists(username);
		
		if (isUsernameExists) {
			request.setAttribute("errorMessage", "Username already exist");
			RequestDispatcher dispatcher 
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");       
		    dispatcher.forward(request, response);
		} else {
			userDAO.insertUser(username, password);
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

}
