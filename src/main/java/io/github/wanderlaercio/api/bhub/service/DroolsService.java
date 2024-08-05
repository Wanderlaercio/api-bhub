package io.github.wanderlaercio.api.bhub.service;

import io.github.wanderlaercio.api.bhub.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.model.RuleExecutionResponse;

public interface DroolsService {
    RuleExecutionResponse executeRules(RuleExecutionResponse response, PaymentRuleModel payment);
}
