package com.ray.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping("/customer/list")
	public String listCustomers() {
		return "list-customer";
	}
}
