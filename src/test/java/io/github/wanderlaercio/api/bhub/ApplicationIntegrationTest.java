package io.github.wanderlaercio.api.bhub;

import io.github.wanderlaercio.api.bhub.model.PaymentRuleModel;
import io.github.wanderlaercio.api.bhub.model.RuleExecutionResponse;
import io.github.wanderlaercio.api.bhub.service.DroolsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ApplicationIntegrationTest {

    @Autowired
    private DroolsService droolsService;

    @Test
    public void testRuleExecution() {
        PaymentRuleModel payment = new PaymentRuleModel();
        payment.setProduct("Aprendendo a Esquiar");
        payment.setPrice(100.0);
        payment.setCategory("Virtual");
        payment.setSubcategories("Aventura");

        RuleExecutionResponse response = droolsService.executeRules(new RuleExecutionResponse(), payment);

        assertNotNull(response);
        assertEquals(1, response.getActions().size());
        assertEquals("Adicionado vídeo de Primeiros Socorros", response.getActions().get(0));
    }
}
