package com.example.NimapTest1SpringBoot.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.NimapTest1SpringBoot.entity.Product;
import com.example.NimapTest1SpringBoot.exception.InvalidProduct;
import com.example.NimapTest1SpringBoot.repository.ProdRepository;
import com.example.NimapTest1SpringBoot.service.ProductServece;

@Service
public class ProdServiceImpl implements ProductServece {
	
	@Autowired
	private ProdRepository prodRepos;

	@Override
	public Product addProd(Product prod) {
		
		Product prodObj= prodRepos.save(prod);		
		// TODO Auto-generated method stub
		return prodObj;
	}

	@Override
	public List<Product> getAllProd() {
		// TODO Auto-generated method stub
		List<Product> a1=new ArrayList();
		List<Product> list=prodRepos.findAll();
		Iterator<Product> itr= list.iterator();
		while(itr.hasNext())
		{
			a1.add(itr.next());
		}
		return a1;
	}

	
	@Override
	public Product getProdById(int prodId) throws InvalidProduct {
		// TODO Auto-generated method stub
		if(prodRepos.existsById(prodId))
		{
			Product prod=prodRepos.findById(prodId).get();
			return prod;
		}
		else 
		{
			throw new InvalidProduct("Product not exist");
		}
	}

	
	@Override
	public int updateProd(int prodId, Product newProd) throws InvalidProduct {
		// TODO Auto-generated method stub
		if(prodRepos.existsById(prodId))
		{
			int status=prodRepos.updateProduct(prodId, 
              newProd.getProdName(),
              newProd.getProdPrice());
			
			return status;
		}
		else
		{
			throw new InvalidProduct("Not able to update");
		}
	}

	

//	@Override
//	public int deleteProd(int prodId) throws InvalidProduct {
//		// TODO Auto-generated method stub
//		if(prodRepos.existsById(prodId))
//		{
//			int status=prodRepos.deleteProduct(prodId);
//			return status;
//		}
//		else
//		{
//			throw new InvalidProduct("Not able to Delete");
//		}
//	}
	
	
	@Override
	public Page<Product> getAllProductPage(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return prodRepos.findAll(pageable);
	}
	
	

}
