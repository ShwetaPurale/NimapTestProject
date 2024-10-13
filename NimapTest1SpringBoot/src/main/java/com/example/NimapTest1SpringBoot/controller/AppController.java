package com.example.NimapTest1SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.NimapTest1SpringBoot.dao.CateServiceImpl;
import com.example.NimapTest1SpringBoot.dao.ProdServiceImpl;
import com.example.NimapTest1SpringBoot.entity.Category;
import com.example.NimapTest1SpringBoot.entity.Product;
import com.example.NimapTest1SpringBoot.exception.InvalidProduct;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
	private ProdServiceImpl prodService;
	
	@Autowired
	private CateServiceImpl cateService;
	
//	syntax for add product in category on postman

//	[
//	    {
//	        "productName": "Product 1",
//	        "productPrice": 19.99
//	    },
//	    {
//	        "productName": "Product 2",
//	        "productPrice": 29.99
//	    }
//	]
	@PostMapping("/{catId}/addToCategory")
	public Category addProductToCategory(@PathVariable int catId, @RequestBody List<Product> prod)
	{
		return cateService.addProdToCategory(catId, prod);
		
	}


//	CRUD Operation on Product-------------
	
//	url=http://localhost:3344/api/addProd
	@PostMapping("/addProd")
	public Product createProduct(@RequestBody Product product)
	{
		Product prodObj= prodService.addProd(product);
		return prodObj;
		
	}
	
	
	
//	urlhttp://localhost:3344/api/getAllProd
	@GetMapping(path="/getAllProd")
	public List<Product> getAllProduct()
	{
		return prodService.getAllProd();
	}
	
//	url=http://localhost:3344/api/getProdById/1
	@GetMapping("/getProdById/{pId}")
	public Product getProdById(@PathVariable int pId) throws InvalidProduct
	{
		return prodService.getProdById(pId);
		
	}
	
//	url=http://localhost:3344/api/updateProd/1
	@PutMapping("/updateProd/{pId}")
	public String updateProductById(@PathVariable int pId, @RequestBody Product prod) throws InvalidProduct
	{
		int status=prodService.updateProd(pId, prod);
		if(status>0)
		{
			return "Updated successfully";
		}
		return "Not able to update";
		
	}
	
//	url=http://localhost:3344/api/deleteProd/1
//	@DeleteMapping("deleteProd/{pId}")
//	public String deleteProdById(@PathVariable int pId) throws InvalidProduct
//	{
//		int status= prodService.deleteProd(pId);
//		if(status>0)
//		{
//			return "Deleted successfully";
//		}
//		return "Not able to delete";
//		
//	}
	
	
//	CRUD Operation on Categories-------------
	
//	{		   
//	    "catName": "Hardware"	   
//	}
//	url=http://localhost:3344/api/addcate
	@PostMapping("/addCate")
	public Category createCategory(@RequestBody Category category)
	{
		Category cateObj= cateService.addCat(category);
		return cateObj;
		
	}
	
	
//	url=http://localhost:3344/api/getAllCategory
	@GetMapping(path="/getAllCategory")
	public List<Category> getAllCategory()
	{
		return cateService.getAllCate();
	}
	
//	url=http://localhost:3344/api/getCateById/1
	@GetMapping("/getCateById/{cId}")
	public Category getCategoryById(@PathVariable int cId) throws InvalidProduct
	{
		return cateService.getCateById(cId);		
	}
	
	
//	url=http://localhost:3344/api/updateCategory/2
	@PutMapping("/updateCategory/{cId}")
	public String updateCategoryById(@PathVariable int cId, @RequestBody Category category) throws InvalidProduct
	{
		int status=cateService.updateCate(cId, category);
		if(status>0)
		{
			return "Updated successfully";
		}
		return "Not able to update";		
	}
	
	
//	url=http://localhost:3344/api/deleteCategory/2
	@DeleteMapping("deleteCategory/{cId}")
	public String deleteCateById(@PathVariable int cId) throws InvalidProduct
	{
		int status= cateService.deleteCate(cId);
		if(status>0)
		{
			return "Deleted successfully";
		}
		return "Not able to delete";		
	}
	
	
//	Pagination---------------------
//	url=http://localhost:3344/api/prod/all?page=0&size=4
	
	@GetMapping("/prod/all")
	public Page<Product> getAllProductPages(@PageableDefault(size = 5) Pageable pageable)
	{
		return prodService.getAllProductPage(pageable);
		
	}
	
//	url=http://localhost:3344/api/category/all?page=0&size=4
	@GetMapping("/category/all")
	public Page<Category> getAllCategoriesPage(@PageableDefault(size = 5) Pageable pageable)
	{
		return cateService.getAllCategoriesPage(pageable);
		
	}
	
	
}





