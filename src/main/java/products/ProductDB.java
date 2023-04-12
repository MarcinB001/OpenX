package products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NullProductException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDB {

    private List<Product> products;

    public ProductDB() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        products = objectMapper.readValue(new URL("https://fakestoreapi.com/products"), new TypeReference<>() {
        });
    }

    public Map<String, BigDecimal> getCategoriesAndValues() {

        CategoriesAndValue categoriesAndValue = new CategoriesAndValue();

        Map<String, BigDecimal> map = products.stream()
                .collect(Collectors.toMap(Product::getCategory, Product::getPrice, BigDecimal::add));

        map.entrySet().stream().forEach(e -> categoriesAndValue.add(e.getKey(), e.getValue()));

        return categoriesAndValue.getCategoriesAndValues();
    }

    public Product getProduct(int id) throws NullProductException {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(NullProductException::new);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
