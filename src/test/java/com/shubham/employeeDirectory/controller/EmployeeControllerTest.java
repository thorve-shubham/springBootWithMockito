package com.shubham.employeeDirectory.controller;

import com.shubham.employeeDirectory.enitity.Employee;
import com.shubham.employeeDirectory.service.EmployeeService;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@SpringBootTest
//@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

//	@Autowired
	private MockMvc mockMvc;

	//this is only required for rest api testing to create a http request and to test json response



	@Test
	void getAllEmployees() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		Mockito.when(employeeService.findAll()).thenReturn(getEmployees());
//		List<Employee> list = employeeController.getAllEmployees();
//		Assert.assertEquals(1, list.size());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json("[    {\n"
						+ "        \"id\": 1,\n"
						+ "        \"firstName\": \"Shubham\",\n"
						+ "        \"lastName\": \"Thorve\",\n"
						+ "        \"email\": \"thorveshubham@kasapan.com\"\n"
						+ "    }\n"
						+ "]"));
//		employeeController.getAllEmployees();
	}

	private List<Employee> getEmployees(){
		return Arrays.asList(getEmployee());
	}

	private Employee getEmployee(){
		Employee emp = new Employee();
		emp.setId(1);
		emp.setEmail("thorveshubham@kasapan.com");
		emp.setFirstName("Shubham");
		emp.setLastName("Thorve");
		return emp;
	}

	@Test
	void getEmployeeById() {
	}

	@Test
	void addEmployee() {
	}

	@Test
	void updateEmployee() {
	}

	@Test
	void deleteEmployee() {
	}
}