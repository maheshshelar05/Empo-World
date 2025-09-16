package com.service;

import com.dao.EmployeeDao;

public class EmployeeService {

	public void insertData() throws Exception
	{
		EmployeeDao dao=new EmployeeDao();
		dao.insertData();
	}
	
	public void updateData() throws Exception
	{
		EmployeeDao dao=new EmployeeDao();
		dao.updateData();
	}
	public void getEmployee() throws Exception 
	{
		EmployeeDao dao=new EmployeeDao();
		dao.getEmployee();
	}
	public void deleteEmployee() throws Exception 
	{
		EmployeeDao dao=new EmployeeDao();
		dao.deleteEmployee();
	}
	public void getAllEmployee() throws Exception 
	{
		EmployeeDao dao=new EmployeeDao();
		dao.getAllEmployee();
	}
}
