package com.fawryChallenge.model.product;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableShippableProduct extends Product implements Expirable,Shippable {
    private Double weight;
    private LocalDate expireDate;

    public ExpirableShippableProduct(String name, double price, int quantity, Double weight, LocalDate expireDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expireDate = expireDate;
    }

    @Override    public double gtWeight() {
        return weight;
    }


    @Override
    public boolean isExpired() {
         LocalDate today = LocalDate.now();
         if (today.isBefore(expireDate)){
             return true;
         }
         else {
             return false;
         }
    }
}
