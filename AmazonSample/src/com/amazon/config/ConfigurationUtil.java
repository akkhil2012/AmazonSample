package com.amazon.config;

import java.util.ArrayList;
import java.util.List;

import com.amazon.api.model.EssentialProduct;
import com.amazon.api.model.Product;

public class ConfigurationUtil {
	
	private static List<Product> productList = new ArrayList<>();
	
	static {
		for(int i=0;i<100;i++)
		productList.add(new EssentialProduct<>());
		
		
	}
	
	
	public List<Product> loadConfiguration() {
		return productList;
	}

}
