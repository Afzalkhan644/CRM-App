package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Product;

public interface ProductDaO {

	public List<Product> getProducts();

	public void saveProduct(Product product);

	public Product getProducts(int prod_id);

	public void deleteProd(int prod_id);

	public List<Product> searchProduct(String theSearchName);
}
