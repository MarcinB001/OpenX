package products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDBTest {

    Product product1 = new Product("c1", BigDecimal.valueOf(100), 1);
    Product product2 = new Product("c2", BigDecimal.valueOf(150), 2);
    Product product3 = new Product("c1", BigDecimal.valueOf(300), 3);
    Product product4 = new Product("c2", BigDecimal.valueOf(500), 4);

    ProductDB productDB;

    @BeforeEach
    void beforeEach() throws IOException {
        List<Product> products = List.of(product1, product2, product3, product4);

        productDB = new ProductDB();
        productDB.setProducts(products);
    }


    @Test
    void shouldSumPrices() {

        Map<String, BigDecimal> map = new HashMap<>();
        map.put("c1", BigDecimal.valueOf(400));
        map.put("c2", BigDecimal.valueOf(650));

        assertEquals(map, productDB.getCategoriesAndValues());

    }

    @Test
    void shouldReturnProduct2() {

        assertEquals(product2, productDB.getProduct(2));

    }
}