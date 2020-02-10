package com.cg.pda.managingregistrations.repo;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pda.managingregistrations.dto.Admin;
import com.cg.pda.managingregistrations.dto.CustomLoginObject;
import com.cg.pda.managingregistrations.dto.Customer;
import com.cg.pda.managingregistrations.dto.Login;
import com.cg.pda.managingregistrations.exception.InvalidLoginCredentialsException;

@Repository
public class RegistrationRepoImpl implements RegistrationRepo {

	@Autowired
	private EntityManager mgr;

	@Override
	public CustomLoginObject validateLogin(Login login) throws InvalidLoginCredentialsException {
		CustomLoginObject loginObject = new CustomLoginObject();
		try {
			Login returnedLogin = mgr.createNamedQuery("validateLoginWithoutRole", Login.class)
					.setParameter("userName", login.getUserName()).setParameter("password", login.getPassword())
					.getSingleResult();

			if (returnedLogin.getRole().equalsIgnoreCase("Admin")) {

				Admin admin = mgr.createNamedQuery("getAdminByUserName", Admin.class)
						.setParameter("userName", login.getUserName()).getSingleResult();
				loginObject.setAdmin(admin);
				loginObject.setCustomer(null);

			} else {

				Customer customer = mgr.createNamedQuery("getCustomerByUserName", Customer.class)
						.setParameter("userName", login.getUserName()).getSingleResult();
				loginObject.setAdmin(null);
				loginObject.setCustomer(customer);

			}
			return loginObject;

		} catch (NoResultException e1) {
			throw new InvalidLoginCredentialsException("Invalid Login Credentials:\nUsername: " + login.getUserName()
			+ "\nPassword: " + login.getPassword());
		}

	}

	@Override
	public Admin registerAdmin(Admin admin) {
		mgr.persist(admin);
		Login login = new Login();
		login.setUserName(admin.getUserName());
		login.setPassword(admin.getPassword());
		login.setRole("Admin");
		mgr.persist(login);
		return admin;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		mgr.persist(customer);
		Login login = new Login();
		login.setUserName(customer.getUserName());
		login.setPassword(customer.getPassword());
		login.setRole("Customer");
		mgr.persist(login);
		return customer;
	}

}
