package com.cg.pda.managingdeliveries.repo;

import java.util.List;

import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.dto.Pizza;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;

public interface OrderRepo {
	
	Order createNewOrder(Order order);
	
	List<Order> viewAllOrders();
	
	Order findOrderById(int orderId) throws InvalidOrderException;
	
	List<Pizza> listOfPizzasForAnOrder(int orderId);
	
	boolean updateOrderStatus(Order order);
	
}
