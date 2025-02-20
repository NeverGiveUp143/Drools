package com.DRL.Order.Service;

import org.kie.api.runtime.KieSession;

import com.DRL.Order.Config.DroolsConfig;
import com.DRL.Order.Models.Order;

public class OrderService {

	public Order getOrderDiscount(Order order) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("DiscountSession");
		org.kie.api.runtime.rule.Agenda agenda = kieSession.getAgenda();
		if(agenda !=  null) {
			agenda.getAgendaGroup("Tax").setFocus();
		}		
		kieSession.insert(order);
		kieSession.fireAllRules();
		if(agenda !=  null) {
			agenda.getAgendaGroup("Discount").setFocus();
		}		
		kieSession.insert(order);
		kieSession.fireAllRules();		
		kieSession.dispose();
		return order;
	}

}