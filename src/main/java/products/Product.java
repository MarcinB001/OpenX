package products;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    public Product() {
    }

    public Product(String _category, BigDecimal _price, int _id) {
        category = _category;
        price = _price;
        id = _id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public Rating getRating() {
        return rating;
    }
}

record Rating(double rate, double count) {

}
