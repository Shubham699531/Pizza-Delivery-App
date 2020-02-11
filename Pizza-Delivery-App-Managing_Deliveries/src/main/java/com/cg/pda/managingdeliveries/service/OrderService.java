package com.cg.pda.managingdeliveries.service;

import java.util.List;

import com.cg.pda.managingdeliveries.dto.CustomOrderObject;
import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.dto.Pizza;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;
import com.cg.pda.managingdeliveries.exception.PizzaNotAvailableException;

public interface OrderService {

	Order createNewOrder(Order order);
	
	List<Order> viewAllOrders();
	
	Order findOrderById(int orderId) throws InvalidOrderException;
	
	List<Order> getOrdersByCustomerId(int customerId);
}
