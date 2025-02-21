package com.DRL.Order;

import java.util.List;

import com.DRL.Order.Models.Order;
import com.DRL.Order.Service.OrderService;

public class App {
    public static void main(String[] args) {
       
    	OrderService orderService = new OrderService();
    	Order electronicOrder = new Order(1, "IPhone16", "Express", "Electronic", 99000.45, 99000.45);
    	orderService.getOrderDiscount(electronicOrder);  
    	System.out.println(String.format("Applied %.2f%% Tax for order with price Rs: %.2f", 
    		    electronicOrder.getTax(), electronicOrder.getBasePrice()));
    	System.out.println(String.format("Applied %.2f%% discount for order with price including tax Rs: %.2f", 
    		    electronicOrder.getDiscount(), electronicOrder.getPrice()));
    	System.out.println(String.format("Final price after applying discount Rs: %.2f", 
    		    electronicOrder.getFinalPrice()));
    	
    	System.out.println("*****************");
    	
    	ListOfOrders();
    	
    }
    
    public static void ListOfOrders() {   	
    	OrderService orderService = new OrderService();
    	List<Order> orderList = List.of(new Order(1, "IPhone16", "Express", "Electronic", 99000.45, 99000.45),
    			new Order(2, "SamsungS25", "Express", "Electronic", 147000, 147000), new Order(3, "One-Plus", "Express", "Electronic", 147000, 147000),
    			new Order(4,"IPhone16", "Express", "Electronic", 99000.45, 99000.45));
    	
    	orderList = orderService.getOrders(orderList); 
    	
    	orderService.getOrdersReport(orderList);
    }
}
