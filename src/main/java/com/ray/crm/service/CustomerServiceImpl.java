package com.ray.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.crm.dao.CustomerDAO;
import com.ray.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public int saveCustomer(Customer customer) {
		return customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomerById(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDAO.searchCustomers(theSearchName);
	}

}
