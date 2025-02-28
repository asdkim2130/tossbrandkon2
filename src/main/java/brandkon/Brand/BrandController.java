package brandkon.Brand;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/brands")
    public List<BrandResponse> getAllBrandList(@RequestParam(required = false)String category){
        return brandService.allBrandList();
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponse findByBrandId(@PathVariable Long brandId){
        return brandService.findByBrandId(brandId);
    }

}


