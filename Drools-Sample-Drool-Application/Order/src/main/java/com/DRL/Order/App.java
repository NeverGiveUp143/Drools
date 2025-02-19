package com.DRL.Order;

import com.DRL.Order.Models.Order;
import com.DRL.Order.Service.OrderService;

public class App {
    public static void main(String[] args) {
       
    	OrderService orderService = new OrderService();
    	Order electronicOrder = new Order();
    	electronicOrder.setOrderId(1);
    	electronicOrder.setProductName("IPhone16");
    	electronicOrder.setOrderType("Express");
    	electronicOrder.setProductType("Electronic");
    	electronicOrder.setPrice(99000.45);
    	orderService.getOrderDiscount(electronicOrder);   	
    	System.out.println(String.format("Applied %.2f%% discount for order with price: %.2f Rs", 
    		    electronicOrder.getDiscount(), electronicOrder.getPrice()));
    	System.out.println(String.format("final price after discount: %.2f Rs", 
    		    electronicOrder.getFinalPrice()));
    }
}
