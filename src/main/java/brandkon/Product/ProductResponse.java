package brandkon.Product;

public record ProductResponse(Long id,
                              String brandName,
                              String productName,
                              int price,
                              String imageUrl) {
}


