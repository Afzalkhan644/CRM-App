package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProductDaO;
import com.luv2code.springdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
private	ProductDaO productDAO;
	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}
	@Override
	@Transactional
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.saveProduct(product);
	}
	@Override
	@Transactional
	public Product getProducts(int prod_id) {
		// TODO Auto-generated method stub
		return productDAO.getProducts(prod_id);
	}
	@Override
	@Transactional
	public void deleteProd(int prod_id) {
		// TODO Auto-generated method stub
		productDAO.deleteProd(prod_id);
	}

	 @Override
	    @Transactional
	    public List<Product> searchProduct(String theSearchName) {

	        return productDAO.searchProduct(theSearchName);
	    }
	
	
}
