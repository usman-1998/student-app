package com.ty.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.student.dao.SudentDao;
import com.ty.student.dto.Student;

public class EditStudentServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		
		Student student = new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setEmail(email);
		student.setPhone(Long.parseLong(phone));
		student.setAge(Integer.parseInt(age));
		
		SudentDao dao = new SudentDao();
		dao.updateStudent(student);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html><body><h1 style=\"color:orange;\">Student updated</h1></body></html>");
		resp.sendRedirect("createstudent.jsp");	
		
	}
}
