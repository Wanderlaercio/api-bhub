package io.github.wanderlaercio.api.bhub.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DroolsSessionFactory {

    private final KieSession kieSession;

    @Autowired
    public DroolsSessionFactory(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public KieSession getKieSession() {
        return kieSession;
    }
}
