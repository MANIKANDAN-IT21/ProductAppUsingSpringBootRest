package com.cts.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "product_info")
@Data
//@AllArgsConstructor
public class Product {
	
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	
	@NotBlank(message="Product can't be NULL or Blank")//it not allow ""," ","  ",null
//	@NotNull
//	@NotEmpty // it allow "   ", but  "" not allow
	private String productName;
	
	@Column(name = "Price") // it's our wish put the name
	@Min(value = 100,message = "min price is 100")
	@Max(value = 100000,message = "it allow max 10000 price only")
	private int productPrice;
	
	@Size(min = 5,max = 12,message = "Enter the length must(5,12)")
	private String productCategory;
	@Positive(message = "Please enter the Postive number, even not 0")
	@Column(name = "Quantity") // it's our wish put the name
	private int productQuantity;

	public Product() {
		System.out.println("default constructor");
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
