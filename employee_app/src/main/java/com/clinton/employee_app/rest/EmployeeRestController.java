package com.clinton.employee_app.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinton.employee_app.entity.Employee;
import com.clinton.employee_app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee findByID(@PathVariable int employeeID) {
		Employee employee = employeeService.findByID(employeeID);
		
		return employee;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {
//		theEmployee.setId(0); serves both as saving and updating -- NOT A GOOD PRACTISE [write seperate function for updating]
		
		employeeService.saveEmployee(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public void deleteEmployee(@PathVariable int employeeID) {
		employeeService.deleteEmployee(employeeID);
	}
	

}
