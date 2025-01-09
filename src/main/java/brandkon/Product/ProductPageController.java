package brandkon.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductPageController {

    private final ProductRepository productRepository;

    public ProductPageController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/pages")  //동일 Url충돌로 endpoint 변경
    public List<ProductResponse>getAll(@RequestParam(defaultValue = "1")int page,
                               @RequestParam(defaultValue = "3")int size){

        Pageable pageable = PageRequest.of(page - 1, size);


        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.getContent()
                .stream()
                .map(product -> new ProductResponse(
                        product.getProductId(),
                        product.getProductName(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl()
                ))
                .toList();
    }



}


