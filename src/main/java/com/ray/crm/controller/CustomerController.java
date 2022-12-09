package com.ray.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ray.crm.dao.CustomerDAO;
import com.ray.crm.entity.Customer;

@Controller
public class CustomerController {
	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerController(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@RequestMapping("/customer/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
}
