package com.example.NimapTest1SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.NimapTest1SpringBoot.entity.Product;

public interface ProdRepository extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Product p SET p.prodName=:pName, p.prodPrice=:pPrice where p.prodId=:pId")
	public int updateProduct(@Param("pId") int prodId, @Param("pName") String prodName,
			@Param("pPrice") float prodPrice);
	
	
//	@Transactional
//	@Modifying
//	@Query("DELETE from Product p where p.prodId=prId")
//	public int deleteProduct(@Param("prId") int prodId);
}
