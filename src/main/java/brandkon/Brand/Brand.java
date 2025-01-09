package brandkon.Brand;

import brandkon.Category.Category;
import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    private String name;
    private String imageUrl;
    private String brandName;
    private int price;

    @ManyToOne
    private Category category;

    protected Brand() {
    }

    public Brand(Long brandId, String name, String imageUrl) {
        this.brandId = brandId;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    //getter


    public Long getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
