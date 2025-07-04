package com.fawryChallenge.model.product;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product implements Expirable{
    private LocalDate expireDate;


    public ExpirableProduct(String name, double price, int quantity, LocalDate expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    @Override
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        if (expireDate.isBefore(today)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public LocalDate getExpireDate() {
        return expireDate;
    }
}
