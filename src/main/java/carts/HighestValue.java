package carts;

import exceptions.NullProductException;
import products.ProductDB;
import users.Name;
import users.User;
import users.UserDB;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class HighestValue {

    private CartDB cartDB;
    private ProductDB productDB;
    private UserDB userDB;

    public HighestValue(CartDB _cartDB, ProductDB _productDB, UserDB _userDB) {
        cartDB = _cartDB;
        productDB = _productDB;
        userDB = _userDB;
    }

    public Map<Cart, BigDecimal> GetCartAndItsTotalValue() throws NullProductException {
        BigDecimal highestTotalValue = BigDecimal.valueOf(0);
        Cart highestCart = null;
        for (Cart cart : cartDB.getCarts()) {
            BigDecimal totalValue = BigDecimal.valueOf(0);
            for (CartProduct cartProduct : cart.getProducts()) {
                for (int i = 0; i < cartProduct.quantity(); ++i)
                    totalValue = totalValue.add(productDB.getProduct(cartProduct.productId()).getPrice());
            }
            if (totalValue.compareTo(highestTotalValue) > 0) {
                highestTotalValue = totalValue;
                highestCart = cart;
            }
        }
        Map<Cart, BigDecimal> map = new HashMap<>();
        map.put(highestCart, highestTotalValue);
        return map;
    }

    public Name getOwnerName(Cart cart) {
        User user = userDB.getUser(cart.getUserId());
        return user.getName();
    }
}


