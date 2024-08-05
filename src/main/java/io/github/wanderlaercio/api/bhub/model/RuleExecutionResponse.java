package io.github.wanderlaercio.api.bhub.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class RuleExecutionResponse {
    private List<String> actions = new ArrayList<>();
    private String message;

    public RuleExecutionResponse() {}

    public RuleExecutionResponse(List<String> actions, String message) {
        this.actions = actions;
        this.message = message;
    }

    public void addAction(String action) {
        this.actions.add(action);
    }
}
