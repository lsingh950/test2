package com.apolis.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.product.entity.Product;
import com.apolis.product.entity.ProductData;
import com.apolis.product.service.ProductService;

@RestController
@RequestMapping("/product-service")
public class ProductController {

	@Autowired
	ProductService  productService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product pro) {
		Product product = null;
		try {
			product = productService.saveProduct(pro);
			if (product != null)
				return new ResponseEntity<Product>(product, HttpStatus.OK);
			else
				return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<ProductData>  getAll(){
		ProductData data = new ProductData();
		try {
			List<Product> list =   productService.getAllProducts();
			data.setProducts(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(data.getProducts() != null)
		return new ResponseEntity<ProductData>(data,HttpStatus.OK);
		else
			return new ResponseEntity<ProductData>(data,HttpStatus.NO_CONTENT);
	}
}
