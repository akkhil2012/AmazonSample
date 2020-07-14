package com.amazon.api.model;

import java.util.List;

public interface PaymentGateway {
	
	boolean confirmorder(Long seesionId,List<Product> products);
	

}
