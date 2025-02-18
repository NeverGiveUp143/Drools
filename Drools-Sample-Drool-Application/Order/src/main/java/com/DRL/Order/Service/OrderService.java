package com.DRL.Order.Service;

import org.kie.api.runtime.KieSession;

import com.DRL.Order.Config.DroolsConfig;
import com.DRL.Order.Models.Order;

public class OrderService {

	public Order getOrderDiscount(Order order) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("DiscountSession");
		kieSession.insert(order);
		kieSession.fireAllRules();
		kieSession.dispose();
		return order;
	}

}