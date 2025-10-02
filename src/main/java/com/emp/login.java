package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch409", "root", "Mahesh@123");
			PreparedStatement ps = c.prepareStatement("select * from employee_data where email=? and password=?");

			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

			    HttpSession session = req.getSession();
			    session.setAttribute("empId", rs.getString(1));
			    session.setAttribute("empName", rs.getString(2));
			    session.setAttribute("dob", rs.getString(3));
			    session.setAttribute("empGender", rs.getString(4));
			    session.setAttribute("email", rs.getString(5));
			    session.setAttribute("mobNo", rs.getLong(6));
			    session.setAttribute("address", rs.getString(7));
			    session.setAttribute("department", rs.getString(8));
			    session.setAttribute("designation", rs.getString(9));
			    session.setAttribute("joiningDate", rs.getString(10));
			    session.setAttribute("salary", rs.getString(11));
			    session.setAttribute("aadharNO", rs.getString(12));

			    RequestDispatcher rs1 = req.getRequestDispatcher("/profile.jsp");
			    rs1.forward(req, resp);   
			} 
			else {

				
				resp.setContentType("text/html");

				out.println("<script type='text/javascript'>");
				out.println("alert('Invalid Username or Password!');");
				out.println("window.location='login.html';"); // redirect after alert
				out.println("</script>");
				

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
