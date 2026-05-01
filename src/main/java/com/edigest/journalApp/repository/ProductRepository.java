package com.edigest.journalApp.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edigest.journalApp.entity.ProductEntry;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntry,Long> {
	
	Optional<ProductEntry>findByTitle(String name);
	Optional<ProductEntry>findById(long id);

}
