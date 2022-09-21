package com.shubham.employeeDirectory.service;

import com.shubham.employeeDirectory.enitity.Employee;
import java.util.List;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public boolean delete(int id);
	public Employee save(Employee employee);
}
