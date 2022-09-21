package com.shubham.employeeDirectory.service;

import com.shubham.employeeDirectory.dao.EmployeeDAO;
import com.shubham.employeeDirectory.enitity.Employee;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
//@Prepar
class EmployeeServiceImplTest {

	@Mock
	private EmployeeDAO employeeDAO;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	void findAll() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(employeeDAO.findAll()).thenReturn(getAllEmployee());
		List<Employee> list = employeeService.findAll();
		Assert.notNull(list);
	}

	@Test
	void findById() {
	}

	@Test
	void delete() {
	}

	@Test
	void save() {
	}

	private List<Employee> getAllEmployee(){
		return Arrays.asList(getEmployee());
	}

	private Employee getEmployee(){
		Employee emp = new Employee();
		emp.setId(10);
		emp.setEmail("thorveshubahm@gmail.com");
		emp.setFirstName("Shubham");
		emp.setLastName("Thorve");
		return emp;
	}
}