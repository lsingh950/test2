package com.apolis.product.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apolis.product.entity.Product;
import com.apolis.product.repository.ProductRepository;
import com.apolis.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public ResponseEntity<Product> updateProduct(Product product) {
		Product pro = null;
		try {
			 pro = productRepository.save(product);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(pro != null) {
			return new ResponseEntity<Product>(pro,HttpStatus.OK);
		}else {
			return new ResponseEntity<Product>(pro,HttpStatus.NO_CONTENT);	
		}
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<Product> getProductById(Integer productId) {
		Optional<Product> pro =  productRepository.findById(productId);
		return new ResponseEntity<Product>(pro.get(),HttpStatus.OK);
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		 productRepository.deleteById(productId);
		 return true;
	}
	
	@Override
	public ResponseEntity<Product> findByProductDescription(Integer productId, String description) {
		
		Product pro = productRepository.findByProductDescriptionAndId(productId, description);
		return new ResponseEntity<Product>(pro,HttpStatus.OK);
	}
}
