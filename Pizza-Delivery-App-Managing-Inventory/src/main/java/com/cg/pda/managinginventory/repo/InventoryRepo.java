package com.cg.pda.managinginventory.repo;

import java.util.List;

import com.cg.pda.managinginventory.dto.Pizza;
import com.cg.pda.managinginventory.exception.PizzaAlreadyRemovedException;

public interface InventoryRepo {
	
	//Add new pizza
	Pizza addPizza(Pizza pizza);
	
	//Search for pizza based on several fields
	List<Pizza> findPizzaByName(String pizzaName);
	
	List<Pizza> findPizzaByDesc(String pizzaDesc);
	
	List<Pizza> findPizzaByCrustType(String crustType);
	
	List<Pizza> findPizzaBySize(String pizzaSize);
	
	List<Pizza> findPizzaByType(String pizzaType);
	
	List<Pizza> findPizzaByToppings(String topping);
	
	List<Pizza> findAllPizzas();

	//Delete Pizza
	boolean deletePizza(int pizzaId) throws PizzaAlreadyRemovedException;
}
