package com.amazon.api.model;

import java.util.List;
import java.util.UUID;

import com.amazon.config.OrderState;
import com.amazon.db.EssentialProductDAO;
import com.amazon.db.ProductDAO;

public class EssentialProduct<E> extends Product<E> {
	
	private int productId;
	
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "EssentialProduct [hashCode()=" + hashCode() + "]";
	}

	@Override
	public List<Product> displayProduct(E product) {
		return new EssentialProductDAO().fetchProduct(product);
	}

	


}
