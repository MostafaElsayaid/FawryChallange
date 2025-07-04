package com.fawryChallenge.service.shipping.ShippingServiceImpl;

import com.fawryChallenge.model.product.ExpirableShippableProduct;
import com.fawryChallenge.model.product.Shippable;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingServiceImpl implements ShippingService {
    List<ExpirableShippableProduct> shippingItems = new ArrayList<>();

    public ShippingServiceImpl(List<ExpirableShippableProduct> shippingItems) {
        this.shippingItems = shippingItems;
    }

    public List<ExpirableShippableProduct> getShippingItems() {
        return shippingItems;
    }

    @Override
    public String getName() {
        return shippingItems.stream()
                .map(i->i.toString())
                .collect(Collectors.joining(", "));
    }

    @Override
    public double getWeight() {
        return shippingItems.stream()
                .mapToDouble(i -> i.gtWeight())
                .sum();
    }

}
