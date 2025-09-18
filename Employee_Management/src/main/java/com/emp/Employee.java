package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")


public class Employee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String d = request.getParameter("id");
		int id = Integer.parseInt(d);
		String name = request.getParameter("name");
		
		String dob1 = request.getParameter("dob");
		Date dob = Date.valueOf(dob1);
		
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		String phoneNo1 = request.getParameter("phone_number");
		long phoneNo = Long.parseLong(phoneNo1);
		
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		
		String joining_date1 = request.getParameter("joining_date");
		Date joining_date = Date.valueOf(joining_date1);
		
		String salary1 = request.getParameter("salary");
		long salary = Integer.parseInt(salary1);
		
		String aadhar_number = request.getParameter("aadhar_number");

		PrintWriter out = response.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "Mahesh@123");
			PreparedStatement ps = c.prepareStatement("insert into Employee_Data(id,full_name,dob,gender,email,phone_number,address,department,designation,joining_date,salary,aadhar_number)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDate(3, dob);
			ps.setString(4, gender);
			ps.setString(5, email);
			ps.setLong(6, phoneNo);
			ps.setString(7, address);
			ps.setString(8, department);
			ps.setString(9, designation);
			ps.setDate(10, joining_date);
			ps.setLong(11, salary);
			ps.setString(12, aadhar_number);
			int check = ps.executeUpdate();

			if (check > 0) {
				out.println("<h1 style='color:green'>" + "Data is inserted..." + "</h1>");
			} else {
				out.print("<h1 style='backgroundcolor:red'>" + "Data is Not inserted..." + "</h1>");
			}
			c.close();

		} catch (Exception e) {
			out.println(e);
		}

	}

}
