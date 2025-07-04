import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.product.*;
import com.fawryChallenge.service.Checkout.CheckoutImpl.CheckoutServiceImpl;
import com.fawryChallenge.service.Checkout.CheckoutService;
import com.fawryChallenge.service.shipping.ShippingService;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Product cheese = new ExpirableShippableProduct("Cheese", 100, 10, 0.4, LocalDate.now());
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 5, 0.7, LocalDate.now());
        Product scratchCard = new Product("Scratch Card", 50, 10);
       // Product tv = new ShippableProduct("TV", 3000, 5, 5.0);

        Customer customer = new Customer( 1000.0);


        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
       // cart.add(tv,1);

        List<Shippable> shippableItems = cart.shippableItems();
        ShippingService shippingService = new ShippingServiceImpl(shippableItems);
        CheckoutService checkoutService = new CheckoutServiceImpl(shippingService);

        checkoutService.checkout(cart, customer);

    }
}