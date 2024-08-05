package io.github.wanderlaercio.api.bhub.application.controller;
import io.github.wanderlaercio.api.bhub.domain.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.domain.model.RuleExecutionResponse;
import io.github.wanderlaercio.api.bhub.domain.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class DroolsControllerImpl {

    private final DroolsService droolsService;

    @Autowired
    public DroolsControllerImpl(DroolsService droolsService) {
        this.droolsService = droolsService;
    }

    @PostMapping("/execute")
    public ResponseEntity<RuleExecutionResponse> executeRules(@RequestBody PaymentRuleModel payment) {
        try {
            droolsService.executeRules(payment);
            RuleExecutionResponse response = new RuleExecutionResponse(payment.getAction(), "Rules executed successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            RuleExecutionResponse response = new RuleExecutionResponse(null, "Error executing rules: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

