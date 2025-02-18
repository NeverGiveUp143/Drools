package com.DRL.Order.Config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsConfig {

    private final KieServices kieServices = KieServices.Factory.get();

    public KieContainer getKieContainer() {
        return kieServices.getKieClasspathContainer();
    }

    public KieSession getKieSession(String SessionName) {
        return getKieContainer().newKieSession(SessionName);
    }
}
