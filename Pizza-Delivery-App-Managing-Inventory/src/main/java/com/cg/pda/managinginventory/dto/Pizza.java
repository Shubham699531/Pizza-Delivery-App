package com.cg.pda.managinginventory.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "pizza_id_gen", sequenceName = "pizza_id_gen", allocationSize = 1)
@NamedQuery(name = "findPizzaByName", query = "FROM Pizza WHERE pizzaName like :pizzaName")
@NamedQuery(name = "findPizzaByDesc", query = "FROM Pizza WHERE pizzaDesc like :pizzaDesc")
@NamedQuery(name = "findPizzaBySize", query = "FROM Pizza WHERE pizzaSize like :pizzaSize")
@NamedQuery(name = "findPizzaByCrustType", query = "FROM Pizza WHERE crustType like :crustType")
@NamedQuery(name = "findPizzaByType", query = "FROM Pizza WHERE pizzaType like :pizzaType")
@NamedQuery(name = "findPizzaByToppings", query = "FROM Pizza WHERE toppings like :toppings")
@NamedQuery(name = "findAllPizzas", query = "FROM Pizza")
public class Pizza {

	public Pizza() {
	}
	
	@Id
	@GeneratedValue(generator = "pizza_id_gen")
	private int pizzaId;
	private String pizzaName;
	private String pizzaDesc;
	private String pizzaSize;
	private String crustType;
	private boolean extraCheese;
	private String pizzaType;  //Veg/Non-Veg
	private String pizzaStatus; //Removed/Available
	private String toppings;
	private double cost;
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDesc() {
		return pizzaDesc;
	}
	public void setPizzaDesc(String pizzaDesc) {
		this.pizzaDesc = pizzaDesc;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public String getCrustType() {
		return crustType;
	}
	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}
	public boolean isExtraCheese() {
		return extraCheese;
	}
	public void setExtraCheese(boolean extraCheese) {
		this.extraCheese = extraCheese;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getToppings() {
		return toppings;
	}
	public void setToppings(String toppings) {
		this.toppings = toppings;
	}
	public String getPizzaStatus() {
		return pizzaStatus;
	}
	public void setPizzaStatus(String pizzaStatus) {
		this.pizzaStatus = pizzaStatus;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
