package io.github.wanderlaercio.api.bhub.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DroolsSessionFactory {

    private final KieContainer kieContainer;

    @Autowired
    public DroolsSessionFactory(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public KieSession getKieSession() {
        return kieContainer.newKieSession();
    }
}
