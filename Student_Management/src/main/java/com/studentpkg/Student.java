package com.studentpkg;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Student extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		
		String name=request.getParameter("name1");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		long mobile=Long.parseLong(phone);
		String address=request.getParameter("address");
		String course=request.getParameter("course");
		String marks=request.getParameter("marks");
		int marks1=Integer.parseInt(marks);
		
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(dob);
		System.out.println(gender);
		System.out.println(email);
		System.out.println(mobile);
		System.out.println(address);
		System.out.println(course);
		System.out.println(marks1);
		
		
	}
	
}
