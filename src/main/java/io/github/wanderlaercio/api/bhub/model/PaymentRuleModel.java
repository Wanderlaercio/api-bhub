package io.github.wanderlaercio.api.bhub.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class PaymentRuleModel {


    private int id;
    private String product;
    private double price;
    private String category;
    private String subcategories;
    private ArrayList<String> action;


    public PaymentRuleModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategories() {
        return subcategories;
    }

    public void setSubcategorie(String subcategories) {
        this.subcategories = subcategories;
    }

    public void setSubcategories(String subcategories) {
        this.subcategories = subcategories;
    }

    public ArrayList<String> getAction() {
        return action;
    }

    public void setAction(ArrayList<String> action) {
        this.action = action;
    }

    public void addAction(String action) {
        this.action.add(action);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRuleModel that = (PaymentRuleModel) o;
        return id == that.id && Double.compare(price, that.price) == 0 && Objects.equals(product, that.product) && Objects.equals(category, that.category) && Objects.equals(subcategories, that.subcategories) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, price, category, subcategories, action);
    }

    @Override
    public String toString() {
        return "PaymentRuleModel{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", subcategories='" + subcategories + '\'' +
                ", action=" + action +
                '}';
    }
}
