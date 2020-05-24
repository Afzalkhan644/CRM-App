package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Product;

public interface ProductService {
public List<Product> getProducts();

public void saveProduct(Product product) ;

public Product getProducts(int prod_id);

public void deleteProd(int prod_id);

public List<Product> searchProduct(String theSearchName);
}
