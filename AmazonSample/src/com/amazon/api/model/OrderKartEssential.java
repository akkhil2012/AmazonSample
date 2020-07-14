package com.amazon.api.model;

public class OrderKartEssential<E> extends OrderKart<E>{
	
	public E addToKart(E product,int id) {
		return super.addToKart((Product) product,id);
	}

}
