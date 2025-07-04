package com.fawryChallenge.model.cart;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.product.*;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void add(Product product, int quantity){
        if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()){
            System.out.println(product.getName()+" is Expired");
            return;
        }
        if (quantity > product.getQuantity()){
            System.out.println(product.getName()+"Is out of stock");
            return;
        }

        items.add(new CartItem(product,quantity));

    }
    public double getSubTotal(){
        double subTotal =0;
        for (CartItem item : items){
            subTotal += item.getPrice();
        }
        return subTotal;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public List<Shippable> shippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((Shippable) p);
                }
            }
        }
        return shippables;
    }
    public Cart() {
    }
}
