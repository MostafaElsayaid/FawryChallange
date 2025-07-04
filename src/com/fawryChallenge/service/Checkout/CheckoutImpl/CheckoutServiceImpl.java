package com.fawryChallenge.service.Checkout.CheckoutImpl;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.cart.CartItem;
import com.fawryChallenge.model.product.Product;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.Checkout.CheckoutService;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    private double shippingFees = 30;
    private ShippingServiceImpl shippingService ;
    @Override
    public void checkout(Cart cart, Customer customer) {
        if(cart.isEmpty()){
            System.out.println("Cart can't be Empty");
            return;
        }
        double subTotal = cart.getSubTotal();
        double totalAmount = subTotal + shippingFees;

        if (customer.getBalance() < totalAmount){
            System.out.println("Your Balance not enough plz recharge your balance and try again");
            return;
        }
        customer.reduceBalance(totalAmount);

        List<ShippableProduct> shippingProduct = new ArrayList<>();
        double totalWeight = 0;
        for (CartItem item : cart.getItems()){
            Product p = item.getProduct();
            if (p instanceof ShippableProduct){
                shippingProduct.add((ShippableProduct) p);
                totalWeight += ((ShippableProduct) p).gtWeight() * item.getQuantity();
                ShippingServiceImpl shippingService = new ShippingServiceImpl(shippingProduct);
                if (!shippingProduct.isEmpty()){
                    System.out.println("** Shipment notice **");
                    System.out.printf("%dx %s %.0fg%n", item.getQuantity(), shippingService.getName(),totalWeight);
            }

            }
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subTotal);
        System.out.printf("Shipping %.0f%n", shippingFees);
        System.out.printf("Amount %.0f%n", totalAmount);
    }
    }

