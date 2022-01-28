package com.ty.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.dao.*;


import javax.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SudentDao dao = new SudentDao();
		if(dao.deleteStudent(Integer.parseInt(id))) {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><h1>Student Deleted</h1></body></html>");
			resp.sendRedirect("createstudent.jsp");	
			req.setAttribute("message", "Student deleted");
			RequestDispatcher  dispatcher = req.getRequestDispatcher("displayStudent.jsp");
			dispatcher.forward(req, resp);
			
		}
	}

}