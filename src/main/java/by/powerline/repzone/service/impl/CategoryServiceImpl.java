package by.powerline.repzone.service.impl;

import by.powerline.repzone.model.db.Category;
import by.powerline.repzone.repository.CategoryRepository;
import by.powerline.repzone.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
