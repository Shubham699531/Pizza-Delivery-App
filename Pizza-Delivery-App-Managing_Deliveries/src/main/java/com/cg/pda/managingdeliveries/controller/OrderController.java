package com.cg.pda.managingdeliveries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;
import com.cg.pda.managingdeliveries.exception.PizzaNotAvailableException;
import com.cg.pda.managingdeliveries.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping(value = "/add")
	Order createNewOrder(@RequestBody Order orderDetails) throws PizzaNotAvailableException {
		return service.createNewOrder(orderDetails);
	}
	
	@GetMapping()
	List<Order> viewAllOrders(){
		return service.viewAllOrders();
	}
	@GetMapping(value = "/list")
	Order findOrderById(@RequestParam int orderId) throws InvalidOrderException {
		return service.findOrderById(orderId);
	}
}
