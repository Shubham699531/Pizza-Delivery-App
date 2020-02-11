package com.cg.pda.managingregistrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pda.managingregistrations.dto.Admin;
import com.cg.pda.managingregistrations.dto.CustomLoginObject;
import com.cg.pda.managingregistrations.dto.Customer;
import com.cg.pda.managingregistrations.dto.Login;
import com.cg.pda.managingregistrations.exception.InvalidLoginCredentialsException;
import com.cg.pda.managingregistrations.service.RegistrationService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/register")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping(value = "/login")
	CustomLoginObject validateLogin(@RequestBody Login login) throws InvalidLoginCredentialsException {
		return service.validateLogin(login);
	}
	
	@PostMapping(value = "/registerAdmin")
	Admin registerAdmin(@RequestBody Admin admin){
		return service.registerAdmin(admin);
	}
	
	@PostMapping(value = "/registerCustomer")
	Customer registerCustomer(@RequestBody Customer customer) {
		return service.registerCustomer(customer);
	}
}
