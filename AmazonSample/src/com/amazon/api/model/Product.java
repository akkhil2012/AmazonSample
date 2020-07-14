package com.amazon.api.model;

import java.util.List;

import com.amazon.config.OrderState;

public abstract class  Product<E> {
	
	abstract List<Product>  displayProduct(E product);
	
	private OrderState state;

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

}
