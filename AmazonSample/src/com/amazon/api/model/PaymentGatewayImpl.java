package com.amazon.api.model;

import java.util.List;

import com.amazon.config.OrderState;

public class PaymentGatewayImpl implements PaymentGatewayProxy{

	
	
	/*
	 * 
	 * Call the proxy to impersonate as the payment gateway
	 */
	@Override
	public boolean confirmOrder(Long seesionId, List<Product> products) {
		
		for(Product p : products) {
			p.setState(OrderState.LOCKED);
		}
		
		return true;
	}

}
