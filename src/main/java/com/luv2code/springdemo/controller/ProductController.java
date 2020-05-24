package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Product;
import com.luv2code.springdemo.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
public String listProduct(Model theModel) {
		
	List<Product> products=productService.getProducts();
		// get customers from the service
		theModel.addAttribute("products",products);
		return "list-products";
	}
		
	@GetMapping("/showFormForProd")
	public String showFormForProd(Model theModel)
	{
		Product product=new Product();
		theModel.addAttribute("products",product);
		return "product-form";
		
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("products") Product product) {
		
		// save the customer using our service
productService.saveProduct(product);	
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showFormforUpdatProd")
public String FormUpdate(@RequestParam("prod_id") int prod_id,Model theModel) {
		Product product=productService.getProducts(prod_id);
		theModel.addAttribute("products",product);
		
		
		return "product-form";
	}
	@GetMapping("/deleteProd")
	public String deleteProd(@RequestParam("prod_id") int prod_id) {
	productService.deleteProd(prod_id);
	return "redirect:/product/list";
	
}
	
    @PostMapping("/search")
    public String searchProduct(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Product> theProduct = productService.searchProduct(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("products", theProduct);

        return "list-products";        
    }
}
