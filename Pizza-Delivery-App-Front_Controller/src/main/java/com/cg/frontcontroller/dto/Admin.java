package com.cg.frontcontroller.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


@Entity
@NamedQuery(name = "getAdminByUserName", query = "FROM Admin WHERE userName=:userName")
@SequenceGenerator(name = "admin_id_gen", sequenceName = "admin_id_gen", allocationSize = 1)
public class Admin {

	@Id
	@GeneratedValue(generator = "admin_id_gen")
	private int adminId;
	@Column(length = 50)
	private String name;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 50, unique = true)
	private String userName;
	@Column(length = 50)
	private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	}