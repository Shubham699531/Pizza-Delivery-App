package com.cg.pda.managingdeliveries.service;

import java.util.List;

import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;
import com.cg.pda.managingdeliveries.exception.PizzaNotAvailableException;

public interface OrderService {

	Order createNewOrder(Order orderDetails) throws PizzaNotAvailableException;
	
	List<Order> viewAllOrders();
	
	Order findOrderById(int orderId) throws InvalidOrderException;
}
