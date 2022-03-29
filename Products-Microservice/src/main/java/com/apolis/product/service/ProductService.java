package com.apolis.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.apolis.product.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);

	ResponseEntity<Product> updateProduct(Product product);

	List<Product> getAllProducts();

	ResponseEntity<Product> getProductById(Integer productId);

	boolean deleteProduct(Integer productId);

	ResponseEntity<Product> findByProductDescription(Integer productId, String description);
}
