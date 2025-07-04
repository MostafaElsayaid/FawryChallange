package com.fawryChallenge.service.shipping.ShippingServiceImpl;

import com.fawryChallenge.model.cart.CartItem;
import com.fawryChallenge.model.product.ExpirableShippableProduct;
import com.fawryChallenge.model.product.Shippable;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingServiceImpl implements ShippingService {
    List<Shippable> items = new ArrayList<>();

    public ShippingServiceImpl(List<Shippable> items) {
        this.items = items;
    }

    public List<Shippable> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return items.stream()
                .map(Shippable::getName)
                .collect(Collectors.joining(", "));
        }


    @Override
    public double getWeight() {
        double weight = 0;
        for (Shippable item : items) {
            weight += item.gtWeight();
        }
        return weight;
    }
}
