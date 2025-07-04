package com.fawryChallenge.service.Checkout.CheckoutImpl;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.cart.CartItem;
import com.fawryChallenge.model.product.ExpirableShippableProduct;
import com.fawryChallenge.model.product.Product;
import com.fawryChallenge.model.product.Shippable;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.Checkout.CheckoutService;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    private double shippingFees = 30;

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
        List<ExpirableShippableProduct> shippingProduct = new ArrayList<>();
        double totalWeight = 0;


        for (CartItem item : cart.getItems()){
            if (item.getProduct() instanceof ExpirableShippableProduct expirableShippableProduct){
                shippingProduct.add(expirableShippableProduct);
                totalWeight = expirableShippableProduct.gtWeight() * item.getQuantity();

            }
        }
        if (!shippingProduct.isEmpty()){
            System.out.println("** Shipment notice **");
            ShippingServiceImpl shippingService = new ShippingServiceImpl(shippingProduct);
            List<ExpirableShippableProduct> shippableList = shippingService.getShippingItems();
            for (ExpirableShippableProduct s : shippableList){

                System.out.printf("%dx %s %.0fg%n", s.getQuantity(), s.getName(),s.gtWeight() );

            }
            System.out.printf("Total package weight %.1fkg%n", totalWeight/1000);

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

