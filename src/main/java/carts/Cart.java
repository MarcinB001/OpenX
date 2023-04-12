package carts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    private int id;
    private int userId;
    private String date;
    private List<CartProduct> products;

    public Cart() {
    }

    public Cart(int _id, int _userId, List<CartProduct> _products) {
        id = _id;
        userId = _userId;
        products = _products;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

}

record CartProduct(int productId, int quantity) {
}