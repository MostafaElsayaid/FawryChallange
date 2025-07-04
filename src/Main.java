import com.fawryChallenge.model.Customer.Customer;
import com.fawryChallenge.model.cart.Cart;
import com.fawryChallenge.model.product.ExpirableProduct;
import com.fawryChallenge.model.product.ExpirableShippableProduct;
import com.fawryChallenge.model.product.Product;
import com.fawryChallenge.model.product.ShippableProduct;
import com.fawryChallenge.service.Checkout.CheckoutImpl.CheckoutServiceImpl;
import com.fawryChallenge.service.Checkout.CheckoutService;
import com.fawryChallenge.service.shipping.ShippingServiceImpl.ShippingServiceImpl;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Customer customer = new Customer(3000.0);
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("cheese",100,6, LocalDate.of(2025, 7, 10),400.0);
        Product p1 = new Product("Ships",300,5);
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct(" Biscuits",150,6, LocalDate.of(2025, 7, 10),700.0);
        Cart cart = new Cart();
        cart.addItem(cheese,2);
        cart.addItem(biscuits,1);
        cart.addItem(p1,2);

        CheckoutServiceImpl checkoutService = new CheckoutServiceImpl();
        checkoutService.checkout(cart,customer);

    }
}