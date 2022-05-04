package com.clinton.employee_app.dao;

import java.util.List;

import com.clinton.employee_app.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findByID(int id);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteEmployee(int id);
	
}
