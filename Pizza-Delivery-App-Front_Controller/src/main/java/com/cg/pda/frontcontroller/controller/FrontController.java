package com.cg.pda.frontcontroller.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.frontcontroller.dto.Admin;
import com.cg.frontcontroller.dto.CustomLoginObject;
import com.cg.frontcontroller.dto.Customer;
import com.cg.frontcontroller.dto.Login;
import com.cg.frontcontroller.dto.Order;
import com.cg.frontcontroller.dto.Pizza;
import com.cg.pda.frontcontroller.exception.InvalidLoginCredentialsException;
import com.cg.pda.frontcontroller.exception.InvalidOrderException;
import com.cg.pda.frontcontroller.exception.NoPizzaAvailableException;
import com.cg.pda.frontcontroller.exception.PizzaAlreadyRemovedException;
import com.cg.pda.frontcontroller.exception.TypeOfPizzaNotAvailableException;

@RestController
@RequestMapping(value = "/front")
@CrossOrigin(origins = "http://localhost:4200")
public class FrontController {
	
	final String serverIp="localhost";
	final String inventoryMicroserviceUrl="http://" + serverIp + ":8881/inventory";
	final String orderMicroserviceUrl="http://" + serverIp + ":8882/order";
	final String registrationMicroserviceUrl="http://" + serverIp + ":8883/register";

	@Autowired
	private RestTemplate template;

	@PostMapping(value = "/addOrder")
	Order createNewOrder(@RequestBody Order order) {
		return template.postForObject(orderMicroserviceUrl + "/add", order, Order.class);
	}

	@GetMapping(value = "/listOrders")
	List<Order> viewAllOrders() {
		return Arrays.asList(template.getForObject(orderMicroserviceUrl + "/listAll", Order[].class));
	}

	@GetMapping(value = "/getOrder")
	Order findOrderById(@RequestParam int orderId) throws InvalidOrderException {
		return template.getForObject(orderMicroserviceUrl + "/getOrderById?orderId="+ orderId, Order.class);
	}

	@PostMapping(value = "/login")
	CustomLoginObject validateLogin(@RequestBody Login login) throws InvalidLoginCredentialsException {
		return template.postForObject(registrationMicroserviceUrl + "/login", login, CustomLoginObject.class);
	}

	@PostMapping(value = "/registerAdmin")
	Admin registerAdmin(@RequestBody Admin admin) {
		return template.postForObject(registrationMicroserviceUrl + "/registerAdmin", admin, Admin.class);
	}

	@PostMapping(value = "/registerCustomer")
	Customer registerCustomer(@RequestBody Customer customer) {
		return template.postForObject(registrationMicroserviceUrl + "/registerCustomer", customer, Customer.class);
	}

	@PostMapping(value = "/addPizza")
	Pizza addPizza(@RequestBody Pizza pizza) throws TypeOfPizzaNotAvailableException {
		return template.postForObject(inventoryMicroserviceUrl + "/add", pizza, Pizza.class);
	}

	// Search for pizza based on several fields
	@GetMapping(value = "/searchByPizzaName")
	List<Pizza> findPizzaByName(@RequestParam String pizzaName) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl +
				"/searchByPizzaName?pizzaName=" + pizzaName, Pizza[].class));
	}

	@GetMapping(value = "/searchByPizzaDesc")
	List<Pizza> findPizzaByDesc(@RequestParam String pizzaDesc) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl + 
				"/searchByPizzaDesc?pizzaDesc=" + pizzaDesc, Pizza[].class));
	}

	@GetMapping(value = "/searchByCrustType")
	List<Pizza> findPizzaByCrustType(@RequestParam String crustType) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl + 
				"/searchByCrustType?crustType=" + crustType, Pizza[].class));
	}

	@GetMapping(value = "/searchByPizzaSize")
	List<Pizza> findPizzaBySize(@RequestParam String pizzaSize) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl + 
				"/searchByPizzaSize?pizzaSize=" + pizzaSize, Pizza[].class));
	}

	@GetMapping(value = "/searchByPizzaType")
	List<Pizza> findPizzaByType(@RequestParam String pizzaType) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl + 
				"/searchByPizzaType?pizzaType=" + pizzaType, Pizza[].class));
	}

	@GetMapping(value = "/searchByPizzaTopping")
	List<Pizza> findPizzaByToppings(@RequestParam String topping) throws NoPizzaAvailableException {
		return Arrays.asList(template.getForObject(inventoryMicroserviceUrl + 
				"/searchByPizzaTopping?topping=" + topping, Pizza[].class));
	}

	// Delete Pizza
	@GetMapping(value = "/delete")
	boolean deletePizza(@RequestParam int pizzaId) throws PizzaAlreadyRemovedException {
		return template.getForObject(inventoryMicroserviceUrl + "/delete?pizzaId=" + pizzaId, boolean.class);
	}

	@GetMapping(value = "/generalizedSearch")
	Set<Pizza> findPizzaByGeneralizedSearch(@RequestParam String something) throws NoPizzaAvailableException {
		return template.getForObject(inventoryMicroserviceUrl + "/generalizedSearch?something=" + something, Set.class);
	}
	
	@GetMapping(value = "/getOrdersByCustomerId")
	List<Order> getOrdersByCustomerId(@RequestParam int customerId){
		return Arrays.asList(template.getForObject(orderMicroserviceUrl + "/getOrdersByCustomerId?customerId=" + customerId, Order[].class));
	}

}
