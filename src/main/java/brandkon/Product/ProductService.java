package brandkon.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> productList(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getProductId(),
                        product.brand.getBrandName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                )).toList();
    }


    public ProductDetailResponse findDetail(Long productId) {
        Product products = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("해당 상품의 상세내용을 찾을 수 없습니다."));


        ProductDetailResponse.Brand brandResponse = new ProductDetailResponse.Brand(
                products.brand.getBrandId(),
                products.brand.getName(),
                products.brand.getBrandName()
        );

        return new ProductDetailResponse(products.getProductId(),
                products.getProductName(),
                products.getPrice(),
                brandResponse,
                products.getExpirationDays());

    }


}


