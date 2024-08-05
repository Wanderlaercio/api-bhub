package io.github.wanderlaercio.api.bhub.model;

import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRuleModel {
    private int id;
    private String product;
    private double price;
    private String category;
    private String subcategories;
}