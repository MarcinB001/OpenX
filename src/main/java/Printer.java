import carts.Cart;
import carts.CartDB;
import carts.HighestValue;
import products.ProductDB;
import users.User;
import users.UserDB;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Printer {

    private ProductDB productDB;
    private UserDB userDB;
    private CartDB cartDB;
    private HighestValue highestValue;

    public Printer() throws IOException {
        productDB = new ProductDB();
        userDB = new UserDB();
        cartDB = new CartDB();
        highestValue = new HighestValue(cartDB, productDB, userDB);
    }

    public void displayCategoriesAndTheirTotalValue() {
        Map<String, BigDecimal> map = productDB.getCategoriesAndValues();

        for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
            System.out.println("category = " + entry.getKey() + ", total value = " + entry.getValue());
        }

    }

    public void displayCartWithHighestValue() {

        Map<Cart, BigDecimal> map = highestValue.GetCartAndItsTotalValue();

        Cart cart = new Cart();
        BigDecimal value = BigDecimal.valueOf(0);

        for (Map.Entry<Cart, BigDecimal> entry : map.entrySet()) {
            cart = entry.getKey();
            value = entry.getValue();
        }

        System.out.println("Cart with the highest value");
        System.out.println("id: " + cart.getId());
        System.out.println("total value: " + value);

        String firstname = highestValue.getOwnerName(cart).firstname();
        String lastname = highestValue.getOwnerName(cart).lastname();
        System.out.println("owner: " + firstname + " " + lastname);

    }

    public void displayFurthestUsers() {
        List<User> furthestUsers = userDB.getFurthestUsers();

        System.out.println("two users living furthest away from each other");
        System.out.print("first user: ");
        String firstname = furthestUsers.get(0).getName().firstname();
        String lastname = furthestUsers.get(0).getName().lastname();
        System.out.println(firstname + " " + lastname);
        System.out.print("second user: ");
        firstname = furthestUsers.get(1).getName().firstname();
        lastname = furthestUsers.get(1).getName().lastname();
        System.out.println(firstname + " " + lastname);

    }

}
