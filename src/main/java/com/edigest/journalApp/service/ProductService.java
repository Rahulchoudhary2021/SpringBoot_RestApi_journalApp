package com.edigest.journalApp.service;

import java.util.List;

import com.edigest.journalApp.dto.ProductRequestDTO;
import com.edigest.journalApp.dto.ProductResponseDTO;
import com.edigest.journalApp.entity.ProductEntry;

public interface ProductService {
	
	List<ProductEntry> getAllProduct();
	
	ProductResponseDTO addProduct (ProductRequestDTO  entry);
	
	ProductEntry getProductById(Long id);
	
	void deleteProduct(Long id);
	
	ProductResponseDTO updateData(Long id,ProductRequestDTO  entry);

}
