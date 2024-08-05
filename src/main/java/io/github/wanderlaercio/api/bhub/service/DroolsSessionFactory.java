package io.github.wanderlaercio.api.bhub.infraestructure.drools.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

@Component
public class DroolsSessionFactory {

    private final KieContainer kieContainer;

    public DroolsSessionFactory() {
        KieServices kieServices = KieServices.Factory.get();
        this.kieContainer = kieServices.getKieClasspathContainer();
    }

    public KieSession getKieSession() {
        return kieContainer.newKieSession("paymentSession");
    }
}
