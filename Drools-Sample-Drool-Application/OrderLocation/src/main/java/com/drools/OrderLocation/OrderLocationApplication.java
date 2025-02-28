package com.drools.OrderLocation;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.drools.OrderLocation.services.OrderlocationService;

@SpringBootApplication
public class OrderLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderLocationApplication.class, args);
	}
	
	@Bean
	 public KieContainer kieContainer() {
	  return KieServices.Factory.get().getKieClasspathContainer();
	 }
	
	@Bean
    public OrderlocationService orderlocationService() {
        return new OrderlocationService();
    }
	
	@Bean
	 public KieServices kieServices() {
	  return KieServices.Factory.get();
	 }
}