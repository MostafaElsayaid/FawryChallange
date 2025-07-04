package com.fawryChallenge.model.product;

import java.time.LocalDate;

public class ShippableProduct extends Product implements Shippable ,Expirable{
   private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double gtWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public LocalDate getExpireDate() {
        return null;
    }
}
