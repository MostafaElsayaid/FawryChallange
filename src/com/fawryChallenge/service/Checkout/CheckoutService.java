package com.fawryChallenge.service.Checkout;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.cart.CartItem;

public interface CheckoutService {
    void checkout(Cart cart, Customer customer);
}
