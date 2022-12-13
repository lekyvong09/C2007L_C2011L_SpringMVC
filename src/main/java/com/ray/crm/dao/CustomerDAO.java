package com.ray.crm.dao;

import java.util.List;

import com.ray.crm.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int theId);
}
