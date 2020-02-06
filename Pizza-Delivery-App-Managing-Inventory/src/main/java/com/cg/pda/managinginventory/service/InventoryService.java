package com.cg.pda.managinginventory.service;

import java.util.List;

import com.cg.pda.managinginventory.dto.Pizza;
import com.cg.pda.managinginventory.exception.NoPizzaAvailableException;
import com.cg.pda.managinginventory.exception.PizzaAlreadyRemovedException;

public interface InventoryService {

		//Add new pizza
		Pizza addPizza(Pizza pizza);
		
		//Search for pizza based on several fields
		List<Pizza> findPizzaByName(String pizzaName)throws NoPizzaAvailableException;
		
		List<Pizza> findPizzaByDesc(String pizzaDesc)throws NoPizzaAvailableException;
		
		List<Pizza> findPizzaByCrustType(String crustType)throws NoPizzaAvailableException;
		
		List<Pizza> findPizzaBySize(String pizzaSize)throws NoPizzaAvailableException;
		
		List<Pizza> findPizzaByType(String pizzaType)throws NoPizzaAvailableException;
		
		List<Pizza> findPizzaByToppings(String topping)throws NoPizzaAvailableException;

		List<Pizza> findAllPizzas();
		
		//Delete Pizza
		boolean deletePizza(int pizzaId) throws PizzaAlreadyRemovedException;
}
