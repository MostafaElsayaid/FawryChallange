package com.fawryChallenge.service.shipping;

import com.fawryChallenge.model.cart.CartItem;
import com.fawryChallenge.model.product.Shippable;

import java.util.List;

public interface ShippingService {
    String getName();
    double getWeight();

}
