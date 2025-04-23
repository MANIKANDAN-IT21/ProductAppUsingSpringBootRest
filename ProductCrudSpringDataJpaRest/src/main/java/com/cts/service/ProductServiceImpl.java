package com.cts.service;

import java.util.List;




import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	Logger log = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	ProductRepository repository;

	@Override
	public String saveProduct(Product product) {

		log.info("In product...............");
		Product pro=repository.save(product);
		if(pro !=null)
			return "Product saved succesfulyy";
		else
			return "something went wrong";
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro=repository.save(product);
		return pro;
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product delete";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		Optional<Product> optional=repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product Id is Invalid");
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		// TODO Auto-generated method stub
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return repository.findByProductCategory(category);
	}

}
