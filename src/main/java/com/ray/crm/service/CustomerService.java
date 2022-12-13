package com.ray.crm.service;

import java.util.List;

import com.ray.crm.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomerById(int theId);
	void deleteCustomer(int theId);
	List<Customer> searchCustomers(String theSearchName);
}
