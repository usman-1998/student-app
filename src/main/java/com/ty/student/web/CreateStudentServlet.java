package com.ty.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.dao.SudentDao;
import com.ty.student.dto.Student;

public class CreateStudentServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone(Long.parseLong(phone));
		student.setAge(Integer.parseInt(age));
		
		SudentDao dao = new SudentDao();
		dao.saveStudent(student);
		
		req.setAttribute("message", "student added");
		RequestDispatcher  dispatcher = req.getRequestDispatcher("createstudent.jsp");
		dispatcher.forward(req, resp);	
	}

}
