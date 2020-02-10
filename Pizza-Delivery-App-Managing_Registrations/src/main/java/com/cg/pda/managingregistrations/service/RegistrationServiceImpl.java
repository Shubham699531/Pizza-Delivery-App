package com.cg.pda.managingregistrations.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pda.managingregistrations.dto.Admin;
import com.cg.pda.managingregistrations.dto.CustomLoginObject;
import com.cg.pda.managingregistrations.dto.Customer;
import com.cg.pda.managingregistrations.dto.Login;
import com.cg.pda.managingregistrations.exception.InvalidLoginCredentialsException;
import com.cg.pda.managingregistrations.repo.RegistrationRepo;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo repo;
	
	@Override
	public CustomLoginObject validateLogin(Login login) throws InvalidLoginCredentialsException {
		return repo.validateLogin(login);
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		return repo.registerAdmin(admin);
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		return repo.registerCustomer(customer);
	}

}
