package io.github.wanderlaercio.api.bhub.domain.service;

import io.github.wanderlaercio.api.bhub.domain.model.PaymentRuleModel;

public interface DroolsService {
    void executeRules(PaymentRuleModel payment);
}

