package com.example.NimapTest1SpringBoot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.NimapTest1SpringBoot.entity.Category;
import com.example.NimapTest1SpringBoot.entity.Product;
import com.example.NimapTest1SpringBoot.exception.InvalidProduct;
import com.example.NimapTest1SpringBoot.repository.CateRepository;
import com.example.NimapTest1SpringBoot.repository.ProdRepository;
import com.example.NimapTest1SpringBoot.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CateServiceImpl implements CategoryService{
	
	@Autowired
	private CateRepository cateRepos;
	
	@Autowired
	public ProdRepository prodRepos;

	@Override
	public Category addCat(Category categories) {
		// TODO Auto-generated method stub
		Category category=cateRepos.save(categories);
		return category;
	}

	@Override
	public List<Category> getAllCate() {
		// TODO Auto-generated method stub
		List<Category> a1=new ArrayList();
		List<Category> list=cateRepos.findAll();
		Iterator<Category> itr= list.iterator();
		while(itr.hasNext())
		{
			a1.add(itr.next());
		}
		return a1;
	}

	@Override
	public Category getCateById(int cateId) throws InvalidProduct {
		// TODO Auto-generated method stub
		if(cateRepos.existsById(cateId))
		{
			Category stud=cateRepos.findById(cateId).get();
			return stud;
		}
		else {
			throw new InvalidProduct("Student not Present");
		}
	}

	@Override
	public int updateCate(int cateId, Category newCate) throws InvalidProduct {
		// TODO Auto-generated method stub
		if(cateRepos.existsById(cateId))
		{
		  int status= cateRepos.updateCategory(cateId,
				 				 
				  newCate.getCatName());		  
		  
		  return status;
		}
		else 
		{
		 throw new InvalidProduct("Not able to update");
		}
	}

	@Override
	public int deleteCate(int cateId) throws InvalidProduct {
		// TODO Auto-generated method stub
		if(cateRepos.existsById(cateId))
		{
			int status=cateRepos.deleteCategory(cateId);
			return status;
		}
		else
		{
		throw new InvalidProduct("Not able to Delete");
		}
	}

	@Override
	public Category addProdToCategory(int catId, List<Product> product) {
		// TODO Auto-generated method stub
		Category category = cateRepos.findById(catId).orElseThrow(() -> 
		new EntityNotFoundException("Category not found"));
		
		for(Product prod: product)
		{
			prod.setCategory(category);
			prodRepos.save(prod);
			category.getProduct().add(prod);
		}
		return cateRepos.save(category);
	}

	@Override
	public Page<Category> getAllCategoriesPage(Pageable pageable) {
		// TODO Auto-generated method stub		
		return cateRepos.findAll(pageable);
	}
	
	


}
