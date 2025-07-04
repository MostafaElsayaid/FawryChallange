package com.fawryChallenge.model.product;

public class ShippableProduct extends Product implements Shippable{
   private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double gtWeight() {
        return weight;
    }
}
