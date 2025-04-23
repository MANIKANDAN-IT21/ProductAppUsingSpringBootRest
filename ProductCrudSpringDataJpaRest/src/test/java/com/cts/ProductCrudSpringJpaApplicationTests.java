package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudSpringJpaApplicationTests {
	@Mock
	ProductRepository repository;
	
	@InjectMocks
	ProductServiceImpl service;
	
	@Test
	void saveProductTest() {
		Product product=new Product("samgung",23000,"electronic",20);
		Mockito.when(repository.saveProduct(product)).thenReturn("product Saved Successfully");
		
		String respose= service.saveProduct(product);
		assertEquals("product Saved Successfully", respose);
	}
//	-------------------------------------------------without mock
//	@Autowired
//	ProductService service;
//	
//	@Test
//	void saveProductTest() {
//		Product product=new Product("samgung",23000,"electronic",20);
//		String respose= service.saveProduct(product);
//		assertEquals("product Saved Successfully......", respose);
//	}

}
