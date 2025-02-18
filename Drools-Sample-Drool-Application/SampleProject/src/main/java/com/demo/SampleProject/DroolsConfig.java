package com.demo.SampleProject;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsConfig {

    private static final KieServices kieServices = KieServices.Factory.get();

    public static KieContainer getKieContainer() {
        return kieServices.getKieClasspathContainer();
    }

    public static KieSession getKieSession() {
        return getKieContainer().newKieSession("defaultKieSession");
    }
}
