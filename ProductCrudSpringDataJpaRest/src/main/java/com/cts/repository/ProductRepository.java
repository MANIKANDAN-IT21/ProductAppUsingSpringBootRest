package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//	
//	public abstract String saveProduct(Product product);// insert //sa
//
//	public abstract String updateProduct(Product product);// update
//
//	public abstract String removeProduct(int productId);// delete
//
//	public abstract String getProduct(int product);// get
//
//	public abstract List<Product> getAllProducts();// show the all product
	
	
//	@Query("select p from Product p where p.productPrice between ?1 and ?2")
//	public abstract List<Product> getAllProductsBetween(int intialPrice, int finalPrice);
	public abstract List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);
 

//	public abstract List<Product> getAllProductsBetween(int initialPrice, int finalPrice);// there are two values
//																							// 1000-500

//	public abstract List<Product> getGreaterPrice(int wantPrice);

//	public abstract List<Product> getAllProductsByCategory(String category);
	
//	@Query("select p from Product p where p.productCategory=?1")
//	public abstract List<Product> getAllProductsByCategory(String category);
	
	public abstract List<Product> findByProductCategory(String category);

}
