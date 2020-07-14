package com.amazon.api.model;

import com.amazon.db.EssentialProductDAO;

public abstract class OrderKart<E> {
	EssentialProductDAO essentialProductDAO
	                = new EssentialProductDAO<>();
	public  E addToKart(Product p,int id) {
		return (E) essentialProductDAO.addProductToKart(p,id);
	}

}
