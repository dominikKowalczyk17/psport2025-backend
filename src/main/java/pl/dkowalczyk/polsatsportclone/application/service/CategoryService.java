package pl.dkowalczyk.polsatsportclone.application.service;

import org.springframework.stereotype.Service;
import pl.dkowalczyk.polsatsportclone.application.dto.CategoryDTO;
import pl.dkowalczyk.polsatsportclone.domain.model.Category;
import pl.dkowalczyk.polsatsportclone.domain.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryMapper.toDTOList(categories);
    }
}