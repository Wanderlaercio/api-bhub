package io.github.wanderlaercio.api.bhub.domain.model;
import java.util.List;

public class RuleExecutionResponse {
    private List<String> actions;
    private String message;

    // Construtores
    public RuleExecutionResponse() {}

    public RuleExecutionResponse(List<String> actions, String message) {
        this.actions = actions;
        this.message = message;
    }

    // Getters e Setters
    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
