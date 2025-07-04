package com.fawryChallenge.service.Checkout.CheckoutImpl;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.cart.CartItem;
import com.fawryChallenge.model.product.*;
import com.fawryChallenge.service.Checkout.CheckoutService;
import com.fawryChallenge.service.shipping.ShippingService;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.util.*;

public class CheckoutServiceImpl implements CheckoutService {
    private double shippingFees = 30;
    private ShippingService shippingService;

    public CheckoutServiceImpl(ShippingService shippingService){
        this.shippingService = shippingService;
    }

    @Override
    public void checkout(Cart cart, Customer customer) {
        if (cart.isEmpty()) {
            System.out.println("Cart can't be Empty");
            return;
        }
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                System.out.println(product.getName() + " Is Expired");
                return;

            }
        }
        double subTotal = cart.getSubTotal();
        double total = subTotal;

        List<Shippable> shippableItems = cart.shippableItems();

        if (!shippableItems.isEmpty()) {
            total += shippingFees;
            System.out.println("** Shipment notice **");
        }
        if (customer.getBalance() < total) {
            System.out.println("You don't have enough balance");
            return;
        }
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        customer.reduceBalance(total);

        if (!shippableItems.isEmpty()) {
            ShippingServiceImpl shippingService = new ShippingServiceImpl(shippableItems);



            Map<String, Integer> nameCount = new LinkedHashMap<>();
            Map<String, Double> nameWeight = new HashMap<>();
            System.out.println(nameWeight);
            for (Shippable item : shippingService.getItems()) {
                String name = item.getName();
                nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
                nameWeight.put(name, item.gtWeight());
            }

            System.out.println("** Shipment notice **");
            for (String name : nameCount.keySet()) {
                int count = nameCount.get(name);
                int grams = (int)(nameWeight.get(name) * 1000);
                System.out.printf("%-20s %dg\n", count + "x " + name, grams);
            }
            System.out.printf("Total package weight %.1fkg\n", shippingService.getWeight());

            System.out.println();
            System.out.println("** Checkout receipt **");
            for (CartItem item : cart.getItems()) {
                System.out.printf("%-20s %d\n", item.getQuantity() + "x " + item.getProduct().getName(), (int)item.getPrice());
            }

        System.out.println("----------------------");
        System.out.println("Subtotal         " + (int)subTotal);
        System.out.println("Shipping         " + (int)(shippableItems.isEmpty() ? 0 : shippingFees));
        System.out.println("Amount           " + (int)total);
        System.out.println("Remaining Balance: " + (double)customer.getBalance());
    }
    }
}

