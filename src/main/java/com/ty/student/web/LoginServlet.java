package com.ty.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.ty.student.dao.UserDao;
import com.ty.student.dto.User;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		UserDao dao = new UserDao();
		User user = dao.validateUser(email, pass);
		if(user!=null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("userName", user.getName());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/getall");
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><h1>INVALID EMAIL OR PASSWORD</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
	}


}
