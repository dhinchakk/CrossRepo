package com.example.springbootcurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcurd.services.CustomerService;
import com.example.springbootcurd.webmodel.Customerweb;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/save")
	public void saveCustomer(@RequestBody Customerweb customerweb) {

		customerService.save(customerweb);

	}

	@GetMapping(value = "/select")
	public List<Customerweb> getallCustomers() {

		return customerService.Select();
	}

	@RequestMapping(value = "/select/{id}")
	public Customerweb getCustomer(@PathVariable Long id) {

		return customerService.Select(id);
	}

	@RequestMapping(value = "/update/{id}")
	public void updateCustomers(@PathVariable Long id, @RequestBody Customerweb customerweb) {

		Customerweb customerweb2 = customerService.Select(id);
		System.out.println("before my sout"+customerweb2);
		System.out.println("--------------");
		
		//customerweb2.id = customerweb.id;
		customerweb2.firstName = customerweb.firstName;
		customerweb2.lastName = customerweb.lastName;
		customerweb2.address = customerweb.address;
		System.out.println(customerweb2 + "id in controller");

		// System.out.println("calling update"+customerweb2);
		customerService.update(customerweb2);
		System.out.println("after update");
	}

	@RequestMapping(value = "/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {

		customerService.delete(id);
	}

}
