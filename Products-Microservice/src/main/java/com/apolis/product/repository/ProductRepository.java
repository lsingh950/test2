package com.apolis.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apolis.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	@Query(value = "from Product pro where pro.productId = ?1 and pro.description =?2")
	Product findByProductDescriptionAndId(Integer productId,String description);
}
