package com.edigest.journalApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequestDTO {

	@NotBlank(message="Title can't be blank !..")
	private String title;
	
	@Positive(message="Price must be greater then 0 !..")
	private double price;
	
	public ProductRequestDTO(){}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
