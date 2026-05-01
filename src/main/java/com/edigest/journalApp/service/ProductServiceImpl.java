package com.edigest.journalApp.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.edigest.journalApp.dto.ProductRequestDTO;
import com.edigest.journalApp.dto.ProductResponseDTO;
import com.edigest.journalApp.entity.ProductEntry;
import com.edigest.journalApp.exception.DuplicateProductException;
import com.edigest.journalApp.exception.ProductNotFoundException;
import com.edigest.journalApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository repo;

	public ProductServiceImpl(ProductRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<ProductEntry> getAllProduct() {
		return repo.findAll();
	}

	@Override
	public ProductResponseDTO addProduct(ProductRequestDTO dto) {
		if (repo.findByTitle(dto.getTitle()).isPresent()) {
			throw new DuplicateProductException("Product with title "+ dto.getTitle() +" already exists!");
		}
		ProductEntry entity = new ProductEntry();
		entity.setTitle(dto.getTitle());
		entity.setPrice(dto.getPrice());
		ProductEntry save = repo.save(entity);
		return new ProductResponseDTO(save.getId(), save.getTitle(), save.getPrice());
	}

	@Override
	public ProductEntry getProductById(Long id) {
		
	return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Oops Product Not Found !"));

	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);

	}

	@Override
	public ProductResponseDTO updateData(Long id, ProductRequestDTO entry) {
		ProductEntry existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Oops Id Not Found !"));
		existing.setTitle(entry.getTitle());
		existing.setPrice(entry.getPrice());
		ProductEntry update = repo.save(existing);
		return new ProductResponseDTO(update.getId(), update.getTitle(), update.getPrice());
	}

}
