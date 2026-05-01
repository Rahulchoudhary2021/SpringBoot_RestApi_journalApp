package com.edigest.journalApp.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.AnyDiscriminator;
import org.hibernate.annotations.Columns;
import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

@Entity
public class ProductEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Positive(message = "Price must greater then 0 !")
	private double price;

	public ProductEntry() {}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
