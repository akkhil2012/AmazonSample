package com.amazon.api.model;

import java.util.List;

import com.amazon.db.EssentialProductDAO;

public class LuxuryProduct<E> extends Product<E> {

	@Override
	public List<Product> displayProduct(E product) {
		return new EssentialProductDAO().fetchProduct(product);
	}


}
