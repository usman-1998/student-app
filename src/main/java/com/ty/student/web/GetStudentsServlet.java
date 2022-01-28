package com.ty.student.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.dao.SudentDao ;
import com.ty.student.dto.Student;

public class GetStudentsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 SudentDao dao = new SudentDao();
		 
		ArrayList<Student> students = dao.getAllUser();
		
		req.setAttribute("students", students);
		RequestDispatcher dispatcher = req.getRequestDispatcher("displaystudent.jsp");
		dispatcher.forward(req, resp);
	}

}
