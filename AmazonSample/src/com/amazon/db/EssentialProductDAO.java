package com.amazon.db;

import java.util.List;

public class EssentialProductDAO<E> extends ProductDAO<E>{

	public List<E> fetchProduct(E product){
		return super.fetchProduct(product);
	}
	
}
