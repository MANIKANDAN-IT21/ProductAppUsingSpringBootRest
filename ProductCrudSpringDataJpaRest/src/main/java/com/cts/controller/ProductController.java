package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController // it is equal to @Controller + @ResponseBody
@RequestMapping("/products") //https:localhost:8080/products this is class level url
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/getMsg")//@ResquestMapping(value="/getsMsg", method=RequestMethod.GET)
	public String sayHello() {
		return "hello manikamaraj";
	}
	@PostMapping("/saveproduct") // http://localhost:8080/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
	@PutMapping("/updateproduct") // http://localhost:8080/products/saveproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@GetMapping("/getproduct/{pid}")//@ResquestMapping(value="/getsMsg", method=RequestMethod.GET)
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
//	@GetMapping("/getall")
//	public Product getAll(@RequestBody Product product) {
//		return service.getAllProducts(list<product>);
//	}
	
	@GetMapping("/getall") // http://localhost:8080/products/getall
	public List<Product> getAllProducts() {
	    return service.getAllProducts();
	}
	@GetMapping("/getproductbetween/{price1}/{price2}") // http://localhost:8080/products/getall
	public List<Product> fetchProductBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
	    return service.getAllProductsBetween(initialPrice,finalPrice);
	}
//	@GetMapping("/getall") // http://localhost:8080/products/getall
//	public List<Product> getAllProducts() {
//	    return service.getAllProducts();
//	}
	
	@GetMapping("/getcat/{productcategory}") // http://localhost:8080/products/getall
	public List<Product> fetchProductCategory(@PathVariable("productcategory") String category) {
	    return service.getAllProductsByCategory(category);
	}
	
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}

}
