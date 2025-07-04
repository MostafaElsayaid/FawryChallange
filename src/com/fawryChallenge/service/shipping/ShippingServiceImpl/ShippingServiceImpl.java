package com.fawryChallenge.service.shipping.ShippingServiceImpl;

import com.fawryChallenge.model.product.Shippable;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingServiceImpl implements ShippingService {
    List<ShippableProduct> shippingItems = new ArrayList<>();

    public ShippingServiceImpl(List<ShippableProduct> shippingItems) {
        this.shippingItems = shippingItems;
    }

    @Override
    public String getName() {
        return shippingItems.stream()
                .map(i->i.getName())
                .collect(Collectors.joining(", "));
    }

    @Override
    public double getWeight() {
        return shippingItems.stream()
                .mapToDouble(i -> i.gtWeight())
                .sum();
    }

}
