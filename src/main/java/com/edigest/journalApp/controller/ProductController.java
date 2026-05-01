package com.edigest.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edigest.journalApp.dto.ProductRequestDTO;
import com.edigest.journalApp.dto.ProductResponseDTO;
import com.edigest.journalApp.entity.ProductEntry;
import com.edigest.journalApp.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductService service;
	
	private static Logger logger=LoggerFactory.getLogger(ProductController.class);

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping()
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO productdto) {
		logger.info("<--Receive Product Request ***-->");
		ProductResponseDTO added = service.addProduct(productdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(added);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> updateProductData(@PathVariable Long id,
			@Valid @RequestBody ProductRequestDTO entry) {
		ProductResponseDTO update = service.updateData(id, entry);
		return ResponseEntity.ok(update);

	}

	@GetMapping
	public List<ProductEntry> getAll() {
		return service.getAllProduct();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntry> getProductById(@PathVariable Long id) {
		Optional<ProductEntry> data = Optional.of(service.getProductById(id));
		if (data.isEmpty()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oops Data Not Found !");
		}
		return ResponseEntity.ok(data.get());
	}

	@DeleteMapping("/{id}")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

}
