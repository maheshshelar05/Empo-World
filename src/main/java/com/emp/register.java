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

public class register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String id  = request.getParameter("id");
//		int id1 = Integer.parseInt(id);
//		
		String name = request.getParameter("name");

		String dob1 = request.getParameter("dob");
		Date dob = null;
		if (dob1 != null && !dob1.isEmpty()) {
			dob = Date.valueOf(dob1); // Only parse when value is present
		}

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
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "Mahesh@123");
			PreparedStatement ps = c.prepareStatement(
					"insert into Employee_Data(full_name,dob,gender,email,phone_number,address,department,designation,joining_date,salary,aadhar_number,password)values(?,?,?,?,?,?,?,?,?,?,?,?)");

			// ps.setInt(1, id1);
			ps.setString(1, name);
			ps.setDate(2, dob);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setLong(5, phoneNo);
			ps.setString(6, address);
			ps.setString(7, department);
			ps.setString(8, designation);
			ps.setDate(9, joining_date);
			ps.setLong(10, salary);
			ps.setString(11, aadhar_number);
			ps.setString(12, password);

			int check = ps.executeUpdate();

			if (check > 0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('Register Successfully..!');"); // show alert
				out.println("window.location='login.html';"); // redirect after OK
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Data is not inserted...');"); // optional alert for failure
				out.println("window.location='register.html';"); // redirect back to registration
				out.println("</script>");
			}
		} catch (Exception e) {
			out.println(e);
		}

	}

}
