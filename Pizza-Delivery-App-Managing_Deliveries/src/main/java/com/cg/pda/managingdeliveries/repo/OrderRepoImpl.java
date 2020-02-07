package com.cg.pda.managingdeliveries.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;

@Repository
public class OrderRepoImpl implements OrderRepo{

	@Autowired
	private EntityManager mgr;
	
	@Override
	public Order createNewOrder(Order orderDetails) {
			mgr.persist(orderDetails);
			return orderDetails;
	}

	@Override
	public List<Order> viewAllOrders() {
		return mgr.createNamedQuery("listAllOrders",Order.class).getResultList();
	}

	@Override
	public Order findOrderById(int orderId) throws InvalidOrderException {
		Order order = mgr.find(Order.class, orderId);
		if(order==null) {
			throw new InvalidOrderException("Order with id: " + orderId + " is invalid.");
		}
		else {
			return order;
		}
	}

}
