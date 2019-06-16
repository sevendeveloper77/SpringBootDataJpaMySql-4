package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	//Static Projections
	/*interface ViewA{
		String getProdCode();
		String getProdModel();
	}
	
	interface ViewB{
		String getProdVendor();
		Double getProdCost();
	}
	List<ViewA> findByProdCost(Double prodCost);
	List<ViewB> findByProdCode(String prodCode);*/
	
	//Dynamic Projections
	
	interface MyData{
		String getProdCode();
		Integer getProdId();
	}
	
	interface MyView{
		Double getProdCost();
		String getProdCode();
	}
	
	<T> List<T> findByProdCost(Double prodCost, Class<T> cls);
	<T> List<T> findByProdCode(String prodCode, Class<T> cls);
	
}
