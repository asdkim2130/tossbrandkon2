package brandkon.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getProductList(@RequestParam(required = false) Long brandId) {
        return productService.productList();
    }

    @GetMapping("/products/{productId}")
    public ProductDetailResponse getDetailProduct(@PathVariable Long productId) {
        return productService.findDetail(productId);

    }
    }


