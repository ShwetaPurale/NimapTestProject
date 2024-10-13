package com.example.NimapTest1SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.NimapTest1SpringBoot.entity.Category;

public interface CateRepository extends JpaRepository<Category, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE Category c SET c.CatName=:cName where c.catId=:cId ")
	public int updateCategory(@Param("cId") int catId, @Param("cName") String CatName);

	@Transactional
	@Modifying
	@Query("DELETE Category c WHERE c.catId=:cId")
	public int deleteCategory(@Param("cId")int catId);

}
