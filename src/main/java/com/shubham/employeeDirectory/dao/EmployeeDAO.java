package com.shubham.employeeDirectory.dao;

import com.shubham.employeeDirectory.enitity.Employee;
import java.util.List;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int id);
	public boolean delete(int id);
	public Employee save(Employee employee);
}
