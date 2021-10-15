package com.chathura.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chathura.usermanagement.dao.UserDAO;
import com.chathura.usermanagement.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
   
    public UserServlet() {
       this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		default:
			listUsers(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User user = new User(name, email, country);
		userDAO.createUser(user);
		System.out.println("User added" + user);
		response.sendRedirect("list");
	}
	
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		System.out.println("user deleted with id="+id);
		response.sendRedirect("list");
	}
	
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.getUserBuId(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
		
	}
	
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User user = new User(id, name, email, country);
		userDAO.updateUser(user);
		System.out.println("user updated"+user);
		response.sendRedirect("list");		
	}
	
	protected void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userDAO.getAllUsers();
		request.setAttribute("userList", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
}
