package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Product;
@Repository
public class ProductDAOImpl implements ProductDaO{
@Autowired
private SessionFactory sessionFactory;
	
	
	
	@Override

	public List<Product> getProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query<Product> query=session.createQuery("from Product order by price",Product.class);
		List<Product> product=query.getResultList();
		
		// TODO Auto-generated method stub
		return product;
	}



	@Override
	public void saveProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}



	@Override
	public Product getProducts(int prod_id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Product product=session.get(Product.class,prod_id);
		return product;
	}



	@Override
	public void deleteProd(int prod_id) {
		Session session= sessionFactory.getCurrentSession();;
		Query<Product> query=session.createQuery("delete from Product where prod_id=:prod_id");
		query.setParameter("prod_id",prod_id);
		query.executeUpdate();
	}



	@Override
	public List<Product> searchProduct(String theSearchName) {
		 // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Product where lower(prod_name) like :theName", Product.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Product", Product.class);            
        }
        
        // execute query and get result list
        List<Product> products = theQuery.getResultList();
                
        // return the results        
        return products;
	}

}
