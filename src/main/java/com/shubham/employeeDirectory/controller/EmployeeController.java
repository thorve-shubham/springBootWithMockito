package com.shubham.employeeDirectory.controller;

import com.shubham.employeeDirectory.enitity.Employee;
import com.shubham.employeeDirectory.service.EmployeeService;
import com.shubham.employeeDirectory.service.EmployeeServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId){
		return employeeService.findById(employeeId);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee){
		employee.setId(0);
		return employeeService.save(employee);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		return employeeService.save(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public boolean deleteEmployee(@PathVariable int employeeId){
		return employeeService.delete(employeeId);
	}
}
