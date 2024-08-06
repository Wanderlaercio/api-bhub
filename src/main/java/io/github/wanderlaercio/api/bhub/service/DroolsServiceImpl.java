package io.github.wanderlaercio.api.bhub.service;

import io.github.wanderlaercio.api.bhub.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.model.RuleExecutionResponse;
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
    public RuleExecutionResponse executeRules(RuleExecutionResponse response, PaymentRuleModel payment) {
        KieSession kieSession = droolsSessionFactory.getKieSession();
        try {
            kieSession.insert(payment);
            kieSession.insert(response);
            kieSession.fireAllRules();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kieSession.dispose();
        }

        return response;
    }
}
