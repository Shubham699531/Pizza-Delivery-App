package com.cg.pda.managingdeliveries.dto;

import java.util.List;

public class CustomOrderObject {

	public CustomOrderObject() {
	}
	
	private Order order;
	private List<Pizza> listOfPizzas;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Pizza> getListOfPizzas() {
		return listOfPizzas;
	}
	public void setListOfPizzas(List<Pizza> listOfPizzas) {
		this.listOfPizzas = listOfPizzas;
	}

}
