package carts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CartDB {

    private List<Cart> carts;

    public CartDB() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        carts = objectMapper.readValue(new URL("https://fakestoreapi.com/carts"), new TypeReference<>() {
        });
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
