package com.example.NimapTest1SpringBoot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NimapTest1SpringBoot.entity.Category;
import com.example.NimapTest1SpringBoot.entity.Product;
import com.example.NimapTest1SpringBoot.exception.InvalidProduct;

public interface CategoryService {
	
	public Category addCat(Category categories);
	public List<Category> getAllCate();
	public Category getCateById(int cateId) throws InvalidProduct;
	public int updateCate(int cateId, Category newCate) throws InvalidProduct;
	public int deleteCate(int cateId) throws InvalidProduct;

	public Category addProdToCategory(int catId, List<Product> prod);

	public Page<Category> getAllCategoriesPage(Pageable pageable);
}
