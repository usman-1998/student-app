package com.ty.student.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.dao.SudentDao;
import com.ty.student.dto.Student;

public class GetStudentServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int parsedId = Integer.parseInt(id);
		
		SudentDao dao = new SudentDao();
		
		Student student = dao.getStudentById(parsedId);
		req.setAttribute("myStudent", student);
		RequestDispatcher  dispatcher = req.getRequestDispatcher("EditStudent.jsp");
		dispatcher.forward(req, resp);	
	}

}
