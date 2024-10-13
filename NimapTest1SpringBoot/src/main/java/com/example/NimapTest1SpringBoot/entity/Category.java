package com.example.NimapTest1SpringBoot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String CatName;	
	
	@OneToMany(mappedBy = "prodId", cascade = CascadeType.ALL)
	private List<Product> product=new ArrayList<Product>();

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return CatName;
	}

	public void setCatName(String catName) {
		CatName = catName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Category(int catId, String catName, List<Product> product) {
		super();
		this.catId = catId;
		CatName = catName;
		this.product = product;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", CatName=" + CatName + ", product=" + product + "]";
	}	

}
