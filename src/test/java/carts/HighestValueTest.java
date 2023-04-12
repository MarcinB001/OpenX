package carts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import products.Product;
import products.ProductDB;
import users.Name;
import users.User;
import users.UserDB;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestValueTest {

    Cart cart1 = new Cart(1, 10,
            List.of(new CartProduct(1, 4), new CartProduct(2, 1)));
    Cart cart2 = new Cart(2, 11,
            List.of(new CartProduct(1, 2), new CartProduct(2, 1)));

    Product product1 = new Product("c1", BigDecimal.valueOf(100), 1);
    Product product2 = new Product("c2", BigDecimal.valueOf(200), 2);

    User user1 = new User(11, new Name("marcin", "baba"));
    User user2 = new User(10, new Name("robert", "lewandowski"));

    CartDB cartDB;
    ProductDB productDB;
    UserDB userDB;

    @BeforeEach
    void beforeEach() throws IOException {
        cartDB = new CartDB();
        cartDB.setCarts(List.of(cart1, cart2));

        productDB = new ProductDB();
        productDB.setProducts(List.of(product1, product2));

        userDB = new UserDB();
        userDB.setUsers(List.of(user1, user2));
    }

    @Test
    void shouldReturnCartIdAndTotalValue() {


        HighestValue highestValue = new HighestValue(cartDB, productDB, userDB);


        Map<Cart, BigDecimal> map = new HashMap<>();
        map.put(cart1, BigDecimal.valueOf(600));

        assertEquals(map, highestValue.GetCartAndItsTotalValue());

    }

    @Test
    void shouldReturnUser2() {

        Name name = new Name("robert", "lewandowski");

        HighestValue highestValue = new HighestValue(cartDB, productDB, userDB);

        assertEquals(name.firstname(), highestValue.getOwnerName(cart1).firstname());
        assertEquals(name.lastname(), highestValue.getOwnerName(cart1).lastname());

    }
}