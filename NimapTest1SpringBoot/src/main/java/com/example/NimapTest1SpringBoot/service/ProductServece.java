package com.example.NimapTest1SpringBoot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NimapTest1SpringBoot.entity.Product;
import com.example.NimapTest1SpringBoot.exception.InvalidProduct;

public interface ProductServece {
	
	public Product addProd(Product prod);
	public List<Product> getAllProd();
	public Product getProdById(int prodId) throws InvalidProduct;
	public int updateProd(int prodId, Product newProd) throws InvalidProduct;
//	public int deleteProd(int prodId) throws InvalidProduct;
	
	Page<Product> getAllProductPage(Pageable pageable);

}
