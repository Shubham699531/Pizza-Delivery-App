package com.cg.pda.managinginventory.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.pda.managinginventory.dto.Pizza;
import com.cg.pda.managinginventory.exception.PizzaAlreadyRemovedException;

@Repository
public class InventoryRepoImpl implements InventoryRepo {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public Pizza addPizza(Pizza pizza) {
		mgr.persist(pizza);
		return pizza;
	}

	@Override
	public List<Pizza> findPizzaByName(String pizzaName) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
		.setParameter("pizzaName", pizzaName).getResultList();
	}

	@Override
	public List<Pizza> findPizzaByDesc(String pizzaDesc) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
				.setParameter("pizzaName", pizzaDesc).getResultList();
	}

	@Override
	public List<Pizza> findPizzaByCrustType(String crustType) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
				.setParameter("pizzaName", crustType).getResultList();
	}

	@Override
	public List<Pizza> findPizzaBySize(String pizzaSize) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
				.setParameter("pizzaName", pizzaSize).getResultList();
	}

	@Override
	public List<Pizza> findPizzaByType(String pizzaType) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
				.setParameter("pizzaName", pizzaType).getResultList();
	}

	@Override
	public List<Pizza> findPizzaByToppings(String topping) {
		return mgr.createNamedQuery("findPizzaByName", Pizza.class)
				.setParameter("pizzaName", topping).getResultList();
	}

	@Override
	public boolean deletePizza(int pizzaId) throws PizzaAlreadyRemovedException {
		Pizza pizza = mgr.find(Pizza.class, pizzaId);
		if(pizza != null) {
			if(!pizza.getPizzaStatus().equalsIgnoreCase("REMOVED")) {
				pizza.setPizzaStatus("Removed");
				return true;
			}
			else {
				throw new PizzaAlreadyRemovedException("This pizza has already "
						+ "been removed.");
			}
			
		}
		else {
			 throw new PizzaAlreadyRemovedException("This pizza does "
					+ "not exist.");
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return mgr.createNamedQuery("findAllPizzas", Pizza.class).getResultList();
	}

}
