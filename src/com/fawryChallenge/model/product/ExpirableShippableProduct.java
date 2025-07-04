package com.fawryChallenge.model.product;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableShippableProduct extends ExpirableProduct implements Expirable,Shippable {

    private Double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expireDate, Double weight) {
        super(name, price, quantity, expireDate);
        this.weight = weight;
    }

    @Override    public double gtWeight() {
        return weight;
    }
}
