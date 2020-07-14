package com.amazon.api.model;

import java.util.List;

public interface PaymentGatewayProxy {
	
	// proxy to impersonate as bank and call actual method when response is done as credit check
	boolean confirmOrder(Long seesionId,List<Product> products);

}
