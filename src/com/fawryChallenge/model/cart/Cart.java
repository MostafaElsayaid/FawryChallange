package com.fawryChallenge.model.cart;

import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.product.Expirable;
import com.fawryChallenge.model.product.ExpirableProduct;
import com.fawryChallenge.model.product.Product;
import com.fawryChallenge.model.product.ShippableProduct;

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

    public void addItem(Product product, int quantity){
        if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()){
            System.out.println(product.getName()+" is Expired");
            return;
        }
        if (quantity > product.getQuantity()){
            System.out.println(product.getName()+"Is out of stock");
            return;
        }
        if (product instanceof ShippableProduct ){

        }

    }
}
