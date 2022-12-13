package com.ray.crm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ray.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	
	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomerById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer deletedCustomer = currentSession.get(Customer.class, theId);
		currentSession.delete(deletedCustomer);
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Customer where firstName like :theName " 
					+ "or lastName like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName + "%");
		} else {
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		return theQuery.getResultList();
	}
	
	
}
