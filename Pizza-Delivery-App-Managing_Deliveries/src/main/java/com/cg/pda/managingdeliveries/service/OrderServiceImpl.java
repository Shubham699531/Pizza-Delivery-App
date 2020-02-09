package com.cg.pda.managingdeliveries.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pda.managingdeliveries.dto.CustomOrderObject;
import com.cg.pda.managingdeliveries.dto.Order;
import com.cg.pda.managingdeliveries.dto.Pizza;
import com.cg.pda.managingdeliveries.exception.InvalidOrderException;
import com.cg.pda.managingdeliveries.repo.OrderRepo;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	private static final double VEG_TOPPING_PRICE = 60;
	private static final double NONVEG_TOPPING_PRICE = 90;
	private static final double EXTRA_CHEESE_TOPPING_PRICE = 120;
	private static final double SMALL_SIZE_FACTOR = 1.2;
	private static final double MEDIUM_SIZE_FACTOR = 1.2;
	private static final double LARGE_SIZE_FACTOR = 1.6;
	private static final double FRESH_PAN_PIZZA_PRICE = 60;
	private static final double CHEESE_BURST_PRICE = 50;
	private static final double WHEAT_THIN_CRUST_PRICE = 40;
	private static final double HAND_TOSSED_PRICE = 0;

	@Autowired
	private OrderRepo repo;

	@Override
	public Order createNewOrder(Order order) {
//		repo.updateOrderStatus(order);
//		List<Pizza> listOfPizzas = repo.listOfPizzasForAnOrder(order.getPizzas());
		order.setOrderAmount(calculateCost(order.getPizzas()));
		order.setOrderStatus("VERIFIED");
		order.setOrderTime(new Date());
		repo.updateOrderStatus(order);
		Order savedOrder = repo.createNewOrder(order);
		return savedOrder;
	}

	@Override
	public List<Order> viewAllOrders() {
		return repo.viewAllOrders();
	}

	@Override
	public Order findOrderById(int orderId) throws InvalidOrderException {
		return repo.findOrderById(orderId);
	}

	private double calculateCost(List<Pizza> listOfPizzas) {
		double amount = 0;
		double extraCheeseCost = 0;
		double extraToppingsCost = 0;
		double sizeCost = 0;
		double crustTypeCost = 0;

		int orderSize = listOfPizzas.size();
		for (int i = 0; i < orderSize; i++) {
			Pizza pizza = listOfPizzas.get(i);

			// Checking for size
			if (pizza.getPizzaSize().equalsIgnoreCase("SMALL")) {
				sizeCost = SMALL_SIZE_FACTOR;
			} else if (pizza.getPizzaSize().equalsIgnoreCase("MEDIUM")) {
				sizeCost = MEDIUM_SIZE_FACTOR;
			} else {
				sizeCost = LARGE_SIZE_FACTOR;
			}

			// Checking for type of crust
			if (pizza.getCrustType().equalsIgnoreCase("FRESHPANPIZZA")) {
				crustTypeCost = FRESH_PAN_PIZZA_PRICE;
			} else if (pizza.getCrustType().equalsIgnoreCase("NEWHANDTOSSED")) {
				crustTypeCost = HAND_TOSSED_PRICE;
			} else if (pizza.getCrustType().equalsIgnoreCase("CHEESEBURST")) {
				crustTypeCost = CHEESE_BURST_PRICE;
			} else {
				crustTypeCost = WHEAT_THIN_CRUST_PRICE;
			}

			// Checking for extra cheese
			if (pizza.isExtraCheese()) {
				extraCheeseCost = EXTRA_CHEESE_TOPPING_PRICE;
			} else {
				extraCheeseCost = 0;
			}
			if (pizza.getToppings() != null) {
				String[] toppings = new String[10];
				toppings = pizza.getToppings().split(" ");
				if (pizza.getPizzaType().equalsIgnoreCase("Veg")) {
					extraToppingsCost = (toppings.length) * VEG_TOPPING_PRICE;
				} else {
					extraToppingsCost = (toppings.length) * NONVEG_TOPPING_PRICE;
				}

			}

			amount += (pizza.getCost()) + extraToppingsCost + extraCheeseCost + sizeCost + crustTypeCost;

		}
		return amount;
	}

}
