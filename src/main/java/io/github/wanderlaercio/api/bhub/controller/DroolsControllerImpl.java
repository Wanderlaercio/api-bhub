package io.github.wanderlaercio.api.bhub.controller;
import io.github.wanderlaercio.api.bhub.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.model.RuleExecutionResponse;
import io.github.wanderlaercio.api.bhub.service.DroolsService;
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
            RuleExecutionResponse response = droolsService.executeRules(new RuleExecutionResponse(),payment);
            response.setMessage("Rules executed successfully " );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            RuleExecutionResponse response = new RuleExecutionResponse(null, "Error executing rules: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

