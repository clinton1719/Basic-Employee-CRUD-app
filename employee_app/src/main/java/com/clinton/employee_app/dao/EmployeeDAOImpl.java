package com.clinton.employee_app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clinton.employee_app.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define entity manager
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get current session
		Session currentSession = entityManager.unwrap(Session.class);

		// create query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findByID(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		Employee employee = currentSession.get(Employee.class, id);

		return employee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteEmployee(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("delete from Employee where id=:employeeID");
		query.setParameter("employeeID", id);
		query.executeUpdate();

	}

}
