package com.cts.service;

import java.util.List;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;

public interface ProductService {
	
	public abstract String saveProduct(Product product);// insert

	public abstract Product updateProduct(Product product);// update

	public abstract String removeProduct(int productId);// delete

	public abstract Product getProduct(int product) throws ProductNotFound;// get

	public abstract List<Product> getAllProducts();//show the all product

	public abstract List<Product> getAllProductsBetween(int initialPrice,int finalPrice);
	
	// there are two values 1000-500

	public abstract List<Product> getAllProductsByCategory(String category);

}
