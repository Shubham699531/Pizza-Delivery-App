package com.cg.pda.managingdeliveries.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.dto.Pizza;
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

	@Override
	public List<Pizza> listOfPizzasForAnOrder(int orderId) {
		return mgr.createNamedQuery("listOfPizzasForAnOrder", Pizza.class)
				.setParameter("orderId", orderId).getResultList();
	}

	@Override
	public boolean updateOrderStatus(Order order) {
		for(int i=0; i<order.getPizzas().size();i++) {
			Pizza pizza = mgr.find(Pizza.class, order.getPizzas().get(i).getPizzaId());
			if(pizza == null) {
				return false;
			}
			else {
				pizza.setOrder(order);
				mgr.merge(pizza);
//				mgr.flush();
			}
		}
		return true;	
	}

	@Override
	public List<Order> getOrdersByCustomerId(int customerId) {
		return mgr.createNamedQuery("listOrdersByCustomerId", Order.class).setParameter("customerId", customerId).getResultList();
	}

}
