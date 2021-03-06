package com.cg.pda.managingregistrations.repo;

import com.cg.pda.managingregistrations.dto.Admin;
import com.cg.pda.managingregistrations.dto.CustomLoginObject;
import com.cg.pda.managingregistrations.dto.Customer;
import com.cg.pda.managingregistrations.dto.Login;
import com.cg.pda.managingregistrations.exception.InvalidLoginCredentialsException;

public interface RegistrationRepo {
	
	CustomLoginObject validateLogin(Login login) throws InvalidLoginCredentialsException;
	
	Admin registerAdmin(Admin admin);
	
	Customer registerCustomer(Customer customer);
	

}
