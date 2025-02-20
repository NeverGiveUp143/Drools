package com.DRL.Order;

import com.DRL.Order.Models.Order;
import com.DRL.Order.Service.OrderService;

public class App {
    public static void main(String[] args) {
       
    	OrderService orderService = new OrderService();
    	Order electronicOrder = new Order(1, "IPhone16", "Express", "Electronic", 99000.45, 99000.45);
    	orderService.getOrderDiscount(electronicOrder);  
    	System.out.println(String.format("Applied %.2f%% Tax for order with price: %.2f Rs", 
    		    electronicOrder.getTax(), electronicOrder.getBasePrice()));
    	System.out.println(String.format("Applied %.2f%% discount for order with price including tax: %.2f Rs", 
    		    electronicOrder.getDiscount(), electronicOrder.getPrice()));
    	System.out.println(String.format("Final price after applying discount: %.2f Rs", 
    		    electronicOrder.getFinalPrice()));
    }
}
