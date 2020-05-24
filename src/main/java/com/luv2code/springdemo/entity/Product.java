package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Product {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_id")
private int prod_id;
	@Column(name="prod_name")
private String prod_name;
	@Column(name="price")
private int price;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getprod_name() {
		return prod_name;
	}
	public void setprod_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product() {
		
	}


}
