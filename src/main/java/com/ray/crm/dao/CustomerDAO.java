package com.ray.crm.dao;

import java.util.List;

import com.ray.crm.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();
	int saveCustomer(Customer customer);
	Customer getCustomer(int theId);
	void deleteCustomerById(int theId);
	List<Customer> searchCustomers(String theSearchName);
}
