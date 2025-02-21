package com.DRL.Order.Service;

import java.util.List;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.DRL.Order.Config.DroolsConfig;
import com.DRL.Order.Models.Order;

public class OrderService {

	public Order getOrderDiscount(Order order) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("DiscountSession");
		org.kie.api.runtime.rule.Agenda agenda = kieSession.getAgenda();
		kieSession.insert(order);
		if (agenda != null) {
			agenda.getAgendaGroup("Tax").setFocus();
		}		
		kieSession.fireAllRules();
		if (agenda != null) {
			agenda.getAgendaGroup("Discount").setFocus();
		}
		kieSession.fireAllRules();
		kieSession.dispose();
		return order;
	}

	public void getOrdersReport(List<Order> orders) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("ReportSession");
		for (Order order : orders) {
			kieSession.insert(order);		
		}
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	public List<Order> getOrders(List<Order> orders) {
		DroolsConfig config = new DroolsConfig();
		KieSession kieSession = config.getKieSession("DiscountSession");
		for (Order order : orders) {
			org.kie.api.runtime.rule.Agenda agenda = kieSession.getAgenda();
			if (agenda != null) {
				agenda.getAgendaGroup("Tax").setFocus();
			}
			kieSession.insert(order);
			kieSession.fireAllRules();
			if (agenda != null) {
				agenda.getAgendaGroup("Discount").setFocus();
			}
			FactHandle factHandle = kieSession.insert(order);
			kieSession.fireAllRules();
			System.out.println(String.format("Applied %.2f%% Tax for order with price: %.2f Rs", order.getTax(),
					order.getBasePrice()));
			System.out.println(String.format("Applied %.2f%% discount for order with price including tax: %.2f Rs",
					order.getDiscount(), order.getPrice()));
			System.out.println(String.format("Final price after applying discount: %.2f Rs", order.getFinalPrice()));
			System.out.println();
			kieSession.delete(factHandle);
		}
		kieSession.dispose();
       
		return orders;
	}

}