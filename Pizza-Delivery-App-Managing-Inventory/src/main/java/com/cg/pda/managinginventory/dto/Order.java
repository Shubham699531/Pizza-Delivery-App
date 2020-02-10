package com.cg.pda.managinginventory.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
@SequenceGenerator(name = "order_id_gen", sequenceName = "order_id_gen", allocationSize = 1, initialValue = 1001)
@NamedQuery(name = "listAllOrders", query = "FROM Order")
public class Order {

	@Id
	@GeneratedValue(generator = "order_id_gen")
	private int orderId;
	private String orderStatus; //Verified
	private double orderAmount;
	private Date orderTime;
	
	//An order can have many pizzas
	@OneToMany(mappedBy = "order")
	private List<Pizza> pizzas;
	
	//A customer can have many orders
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	
//	public List<Pizza> getPizzas() {
//		return pizzas;
//	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
