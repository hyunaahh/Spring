package com.example.demo.customer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@Controller
public class CustomerController {
//@ResponseBody 위에꺼만 썼을때 : @RestController 써야됨! 
	
	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/customer")
	@ResponseBody
	public Iterable<Customer> customer(){
		return repo.findAll();
		
	}
	//localhost/regCustomer?fname=dong&lname=choi
	@GetMapping("/regCustomer")
	@ResponseBody
	public Customer regCustomer(String fname, String lname) {
		return repo.save(new Customer(fname, lname));
	}
	
	@GetMapping("/findCustomer/{firstName}")
	@ResponseBody
	public List<Customer> findCustomer(@PathVariable String firstName){
		return repo.findByfirstName(firstName);
	}
	
	
}
