package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Brand;
import by.powerline.repzone.repository.BrandRepository;
import by.powerline.repzone.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
