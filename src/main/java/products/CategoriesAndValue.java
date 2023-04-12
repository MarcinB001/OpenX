package products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CategoriesAndValue {

    private Map<String, BigDecimal> categoriesAndValues = new HashMap<>();

    public void add(String category, BigDecimal value) {
        categoriesAndValues.put(category, value);
    }

    public Map<String, BigDecimal> getCategoriesAndValues() {
        return categoriesAndValues;
    }
}
