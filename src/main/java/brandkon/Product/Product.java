package brandkon.Product;

import brandkon.Brand.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private int price;
    private String imageUrl;
    private int expirationDays;

    public Product() {
    }

    @ManyToOne
    Brand brand;

    public Product(Long productId, String productName, int price, String imageUrl, int expirationDays) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.expirationDays = expirationDays;
    }

    public Product(Long productId, Brand brand, String productName, int price, String imageUrl) {
        this.productId = productId;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(Long productId, String productName, int price, Brand brand, int expirationDays) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.expirationDays = expirationDays;
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getExpirationDays() {
        return expirationDays;
    }
}


