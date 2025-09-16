package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDao {

	Scanner sc = new Scanner(System.in);
	PreparedStatement stmt;

	public Connection connect() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/batch409";
		String username = "root";
		String password = "Mahesh@123";
		Connection c = DriverManager.getConnection(url, username, password);
		return c;
	}

	public void insertData() throws Exception {

		Connection c = connect();
		try {
			PreparedStatement stmt = c.prepareStatement("insert into employee(id,name,age,salary) values(?,?,?,?)");
			System.out.println("Enter Employee ID ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Employee Name ");
			String name = sc.nextLine();

			System.out.println("Enter Employee Age ");
			String age = sc.nextLine();

			System.out.println("Enter Employee Salary ");
			String salary = sc.nextLine();

			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, age);
			stmt.setString(4, salary);

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Employee data inserted successfully!");
			}
			stmt.close();
			c.close();

		} catch (SQLException e) {
			System.out.println("failed to add Data..." + e);
		}

	}

	public void updateData() throws Exception {
		Connection c = connect();

		try {

			stmt = c.prepareStatement("update employee set age=?,salary=? where id=?");

			System.out.println("Enter Employee ID To Upadate ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Employee updated salary ");
			double salary = sc.nextDouble();
			sc.nextLine();

			System.out.println("Enter Employee current Age ");
			int age = sc.nextInt();
			sc.nextLine();

			stmt.setInt(1, age);
			stmt.setDouble(2, salary);
			stmt.setInt(3, id);

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Employee data Updated successfully!");
			}

			c.close();

		} catch (Exception e) {
			System.out.println("Failed to UPDATE Data");
		}
	}

	public void getEmployee() throws Exception {

		Connection c = connect();
		try {
			stmt = c.prepareStatement("select * from employee where id=?");
			System.out.println("Enter Employee ID to get");
			int id = sc.nextInt();
			sc.nextLine();
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("-----Employee Details-----");
				System.out.println("Employee ID : " + rs.getString("id"));
				System.out.println("Employee Name : " + rs.getString("name"));
				System.out.println("Employee Age : " + rs.getString("age"));
				System.out.println("Employee Salary : " + rs.getString("salary"));
			} else {
				System.out.println("No record exist with ID " + id);
			}

			c.close();

		} catch (Exception e) {

			System.out.println("Failed Load Employee Details For the given Id " + e);
		}

	}
	
	public void deleteEmployee() throws Exception{
		Connection c=connect();
		try
		{
		 stmt=c.prepareStatement("delete from employee where id=?");
		 System.out.println("Enter ID to Delete Employee ");
		 int id=sc.nextInt();
		 sc.nextLine();
		 
		 stmt.setInt(1, id);
		 
		 int rowsAffected = stmt.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Employee with ID " + id + " deleted successfully.");
	        } else {
	            System.out.println("No employee found with ID " + id);
	        }
		 c.close();
		} catch (Exception e) {
			
			System.out.println("Failed to Delete Employee " + e);
		}
	}
	
	public void getAllEmployee() throws Exception{
		Connection c=connect();
		try {
			
			stmt=c.prepareStatement("Select * from employee");
			
			ResultSet rs=stmt.executeQuery();
			
			
			System.out.println("-------All Employee Data--------");
			
			while (rs.next()) {
				System.out.println(
						"------------------------------------------------------------------------------------------");
				
				System.out.println("Employee ID : " + rs.getString("id"));
				System.out.println("Employee Name : " + rs.getString("name"));
				System.out.println("Employee Age : " + rs.getString("age"));
				System.out.println("Employee Salary : " + rs.getString("salary"));
			}
			
			c.close();
		} catch (Exception e) {
		
			System.out.println("Failed to get Employees Data ");
		}
	}
}
