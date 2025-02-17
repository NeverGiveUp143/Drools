package com.demo.SampleProject;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App 
{
    public static void main( String[] args )
    {
    	  Greeting greet = new Greeting();
    	  KieServices kieServices = KieServices.Factory.get();
    	  KieContainer kieContainer =  kieServices.getKieClasspathContainer();
		  KieSession kieSession = kieContainer.newKieSession("greetSession");
		  greet.setMessage("Hello");
		  kieSession.insert(greet);
		  kieSession.fireAllRules();
		  kieSession.dispose();
    }
}
