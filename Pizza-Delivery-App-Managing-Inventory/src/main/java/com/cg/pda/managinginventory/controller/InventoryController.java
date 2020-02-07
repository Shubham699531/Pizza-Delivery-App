package com.cg.pda.managinginventory.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pda.managinginventory.dto.Pizza;
import com.cg.pda.managinginventory.exception.NoPizzaAvailableException;
import com.cg.pda.managinginventory.exception.PizzaAlreadyRemovedException;
import com.cg.pda.managinginventory.exception.TypeOfPizzaNotAvailableException;
import com.cg.pda.managinginventory.service.InventoryService;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

	public InventoryController() {
	}
	
	@Autowired
	private InventoryService service;
	
	@PostMapping(value = "/add")
	Pizza addPizza(@RequestBody Pizza pizza) throws TypeOfPizzaNotAvailableException {
		return service.addPizza(pizza);
	}
	
	//Search for pizza based on several fields
	@GetMapping(value = "/searchByPizzaName")
	List<Pizza> findPizzaByName(@RequestParam String pizzaName)throws NoPizzaAvailableException{
		return service.findPizzaByName("%" +pizzaName+ "%");
	}
	
	@GetMapping(value = "/searchByPizzaDesc")
	List<Pizza> findPizzaByDesc(@RequestParam String pizzaDesc)throws NoPizzaAvailableException{
		return service.findPizzaByDesc("%" +pizzaDesc+ "%");
	}
	
	@GetMapping(value = "/searchByCrustType")
	List<Pizza> findPizzaByCrustType(@RequestParam String crustType)throws NoPizzaAvailableException{
		return service.findPizzaByCrustType("%" +crustType+ "%");
	}
	
	@GetMapping(value = "/searchByPizzaSize")
	List<Pizza> findPizzaBySize(@RequestParam String pizzaSize)throws NoPizzaAvailableException{
		return service.findPizzaBySize("%" +pizzaSize+ "%");
	}
	
	@GetMapping(value = "/searchByPizzaType")
	List<Pizza> findPizzaByType(@RequestParam String pizzaType)throws NoPizzaAvailableException{
		return service.findPizzaByType("%" +pizzaType+ "%");
	}
	
	@GetMapping(value = "/searchByPizzaTopping")
	List<Pizza> findPizzaByToppings(@RequestParam String topping)throws NoPizzaAvailableException{
		return service.findPizzaByToppings("%" +topping+ "%");
	}

	//Delete Pizza
	@GetMapping(value = "/delete")
	boolean deletePizza(@RequestParam int pizzaId) throws PizzaAlreadyRemovedException{
		return service.deletePizza(pizzaId);
	}
	
	@GetMapping(value = "/generalizedSearch")
	Set<Pizza> findPizzaByGeneralizedSearch(@RequestParam String something)throws NoPizzaAvailableException{
		if(something.equals("")) {
			List<Pizza> allPizzas = service.findAllPizzas();
			if(allPizzas.size()==0) {
				throw new NoPizzaAvailableException("No pizzas available currently.");
			}
			else {
				Set<Pizza> setOfPizzas = new HashSet<Pizza>(allPizzas);
				return setOfPizzas;
			}
			
		}
		else {
			Set<Pizza> setOfPizzas = new HashSet<Pizza>();
			setOfPizzas.addAll(service.findPizzaByName("%" + something + "%"));
			setOfPizzas.addAll(service.findPizzaByDesc("%" + something + "%"));
			setOfPizzas.addAll(service.findPizzaByCrustType("%" + something + "%"));
			setOfPizzas.addAll(service.findPizzaBySize("%" + something + "%"));
			setOfPizzas.addAll(service.findPizzaByType("%" + something + "%"));
			setOfPizzas.addAll(service.findPizzaByToppings("%" + something + "%"));
			return setOfPizzas;
		}
	}

}
