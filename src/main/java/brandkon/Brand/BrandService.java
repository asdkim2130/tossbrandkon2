package brandkon.Brand;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandResponse> allBrandList() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> new BrandResponse(
                        brand.getBrandId(),
                        brand.getName(),
                        brand.getImageUrl()))
                .toList();
    }

    public BrandResponse findByBrandId(Long brandId) {

            Brand brands = brandRepository.findById(brandId).orElseThrow(
                    () -> new IllegalArgumentException("해당 브랜드를 찾을 수 업습니다."));

            return new BrandResponse(brands.getBrandId(),
                    brands.getName(),
                    brands.getImageUrl());
        }


}

