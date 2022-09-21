package com.shubham.employeeDirectory.dao;

import com.shubham.employeeDirectory.enitity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
		public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);

		Query theQuery = session.createQuery("from Employee",Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class,id);


		return employee;
	}

	@Override
	public boolean delete(int id) {
		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class,id);
		if(employee!=null){
			session.delete(employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);

		return  employee;
	}
}
