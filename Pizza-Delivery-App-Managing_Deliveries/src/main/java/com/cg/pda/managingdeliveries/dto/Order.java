package com.cg.pda.managingdeliveries.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "OrderDetails")
@SequenceGenerator(name = "order_id_gen", sequenceName = "order_id_gen", allocationSize = 1, initialValue = 1001)
@NamedQuery(name = "listOrdersByCustomerId", query = "FROM Order WHERE customer.customerId=:customerId")
@NamedQuery(name = "listAllOrders", query = "FROM Order")
public class Order {

	@Id
	@GeneratedValue(generator = "order_id_gen")
	private int orderId;
	private String orderStatus; //Completed
	private double orderAmount;
	private Date orderTime;
	
	//An order can have many pizzas
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<Pizza> pizzas;
	
	//A customer can have many orders
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

//Removing getter to prevent fetching list of pizzas while fetching order.	
	public List<Pizza> getPizzas() {
		return pizzas;
	}

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
