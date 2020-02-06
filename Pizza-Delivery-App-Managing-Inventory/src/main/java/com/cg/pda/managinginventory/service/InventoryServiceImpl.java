package com.cg.pda.managinginventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pda.managinginventory.dto.Pizza;
import com.cg.pda.managinginventory.exception.NoPizzaAvailableException;
import com.cg.pda.managinginventory.exception.PizzaAlreadyRemovedException;
import com.cg.pda.managinginventory.repo.InventoryRepo;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepo repo;
	
	@Override
	public Pizza addPizza(Pizza pizza) {
		return repo.addPizza(pizza);
	}

	@Override
	public List<Pizza> findPizzaByName(String pizzaName) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaByName(pizzaName);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public List<Pizza> findPizzaByDesc(String pizzaDesc) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaByDesc(pizzaDesc);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public List<Pizza> findPizzaByCrustType(String crustType) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaByCrustType(crustType);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public List<Pizza> findPizzaBySize(String pizzaSize) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaBySize(pizzaSize);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public List<Pizza> findPizzaByType(String pizzaType) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaByType(pizzaType);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public List<Pizza> findPizzaByToppings(String topping) throws NoPizzaAvailableException {
		List<Pizza> pizzas = repo.findPizzaByToppings(topping);
		if(pizzas.size()==0) {
			throw new NoPizzaAvailableException("No pizzas "
					+ "available in this category.");
		}
		else {
			return pizzas;
		}
	}

	@Override
	public boolean deletePizza(int pizzaId) throws PizzaAlreadyRemovedException {
		return repo.deletePizza(pizzaId);
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return repo.findAllPizzas();
	}

}
