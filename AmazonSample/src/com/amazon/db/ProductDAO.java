package com.amazon.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazon.api.model.EssentialProduct;
import com.amazon.api.model.Product;
import com.amazon.app.SessionManager;
import com.amazon.config.ConfigurationUtil;
import com.amazon.config.OrderState;

public abstract class ProductDAO<E> {

/*	public List<Product> getProductList() {
		return productList;
	}




	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
*/

	private  static List<Product> productList = new ArrayList<>();
	
	private static Map<Long,List<Product>> orderMap = new HashMap<>();
	
	private  List<Product> orderList = new ArrayList<>();
	
	static {
		ConfigurationUtil util = new ConfigurationUtil();
		//util.loadConfiguration();
		productList = util.loadConfiguration();
	}
	
	/*
	 *  to maintain user Order with the list of oreder placed in Map
	 */
	
	/*static {
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		productList.add(new EssentialProduct<>());
		
	}*/
	


	public  Map<Long, List<Product>> getOrderMap() {
		return orderMap;
	}




	public static void setOrderMap(Map<Long, List<Product>> orderMap) {
		ProductDAO.orderMap = orderMap;
	}


	/*
	 * Fetching product from DB; for time being hardcoded
	 */
	List<E> fetchProduct(E product){
		return (List<E>) productList;
	}
	
	
	public E addProductToKart(E product,int id){
		//System.out.println("Element selected  " + productList.get(id));
		productList.get(id).setState(OrderState.PROGRESS);
		orderList.add(productList.remove(id));
		orderMap.put(SessionManager.getSession().getSessionId(), (List<Product>) orderList);
		
		return product;
	}
	
}
