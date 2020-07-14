package com.amazon.app;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.print.attribute.standard.PDLOverrideSupported;

import com.amazon.api.model.EssentialProduct;
import com.amazon.api.model.LuxuryProduct;
import com.amazon.api.model.OrderKartEssential;
import com.amazon.api.model.PaymentGatewayImpl;
import com.amazon.api.model.PaymentGatewayProxy;
import com.amazon.api.model.Product;
import com.amazon.db.EssentialProductDAO;
import com.amazon.db.ProductDAO;

public class AppClient {
	static ProductDAO productDAO = new EssentialProductDAO();
	
	static Lock lock = new ReentrantLock();
	
	public static void main(String args[]) {
		Product p = new EssentialProduct<>();
		/*
		 * 
		 * Session for user begins here
		 * 
		 */
		lock.lock();
		for (int i = 0; i < 10; i++) {
			
				SessionManager sessioManager = new SessionManager();
				sessioManager.setSession(new Session((long) i));
				List<Product> res = new LuxuryProduct().displayProduct(p);

				// 2. Add to order cart
				OrderKartEssential kart = new OrderKartEssential<>();
				kart.addToKart(res.get(1), 1);
				kart.addToKart(res.get(2), 2);
				// for (Product pd : res) { System.out.println("size--> " + pd.toString()); }
			//}

			orderProgess();

			// payment
			PaymentGatewayImpl paymentgateway = new PaymentGatewayImpl();
			//SessionManager sessioManager = new SessionManager();
			Long sessionId = sessioManager.getSession().getSessionId();
			confirmOrder(paymentgateway, sessionId);
			// CHECK IF STATE CHANGED
			orderProgess();
		}
		lock.unlock();
		}
		// count less to other user

	

	// process the per user order:

	private static void orderProgess() {
		Map<Long, List<Product>> m = productDAO.getOrderMap();
		for (Map.Entry<Long, List<Product>> s : m.entrySet()) {
			System.out.println("user: " + s.getKey());
			for (Product prod : s.getValue()) {
				System.out.print(" " + prod.getState() + " " + prod.hashCode());
			}
			System.out.println(" ");
		}
	}

	private static void confirmOrder(PaymentGatewayImpl paymentGateway, Long sessionId) {
		Map<Long, List<Product>> m1 = productDAO.getOrderMap();
		for (Map.Entry<Long, List<Product>> s1 : m1.entrySet()) {
			paymentGateway.confirmOrder(sessionId, s1.getValue());
		}

	}

}
