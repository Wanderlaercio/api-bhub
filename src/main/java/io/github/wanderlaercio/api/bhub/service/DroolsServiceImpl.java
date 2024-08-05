package io.github.wanderlaercio.api.bhub.infraestructure.drools.service;

import io.github.wanderlaercio.api.bhub.domain.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.domain.service.DroolsService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsServiceImpl implements DroolsService {

    private final DroolsSessionFactory droolsSessionFactory;

    @Autowired
    public DroolsServiceImpl(DroolsSessionFactory droolsSessionFactory) {
        this.droolsSessionFactory = droolsSessionFactory;
    }

    @Override
    public void executeRules(PaymentRuleModel payment) {
        KieSession kieSession = droolsSessionFactory.getKieSession();
        kieSession.insert(payment);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}