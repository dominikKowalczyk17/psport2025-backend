package pl.dkowalczyk.polsatsportclone.application.service;

import org.springframework.stereotype.Service;
import pl.dkowalczyk.polsatsportclone.application.dto.CategoryDTO;
import pl.dkowalczyk.polsatsportclone.domain.model.Category;
import pl.dkowalczyk.polsatsportclone.domain.model.SubCategory;
import pl.dkowalczyk.polsatsportclone.domain.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setTitle(categoryDTO.getTitle());
        category.setHref(categoryDTO.getHref());
        if (categoryDTO.getSubmenu() != null) {
            List<SubCategory> subCategories = categoryDTO.getSubmenu().stream()
                    .map(subCategoryDTO -> {
                        SubCategory subCategory = new SubCategory();
                        subCategory.setTitle(subCategoryDTO.getTitle());
                        subCategory.setHref(subCategoryDTO.getHref());
                        subCategory.setCategory(category);  // Ustaw kategorię dla każdej subkategorii
                        return subCategory;
                    })
                    .collect(Collectors.toList());

            // Przypisz subkategorie do kategorii
            category.setSubCategoryList(subCategories);
        }

        categoryRepository.save(category);

        // Przekaż dane w formacie DTO
        return CategoryMapper.toDTO(category);
    }
}