package pl.dkowalczyk.polsatsportclone.application.service;

import pl.dkowalczyk.polsatsportclone.application.dto.CategoryDTO;
import pl.dkowalczyk.polsatsportclone.application.dto.SubCategoryDTO;
import pl.dkowalczyk.polsatsportclone.domain.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    // Mapa jednej kategorii na DTO
    public static CategoryDTO toDTO(Category category) {
        // Sprawdzamy, czy lista subkategorii nie jest null
        List<SubCategoryDTO> submenu = (category.getSubCategoryList() != null && !category.getSubCategoryList().isEmpty()) ?
                category.getSubCategoryList().stream()
                        .map(sub -> new SubCategoryDTO(sub.getTitle(), sub.getHref()))
                        .collect(Collectors.toList()) : null;

        // Tworzymy i zwracamy CategoryDTO
        return new CategoryDTO(category.getId(), category.getTitle(), category.getHref(), submenu);
    }

    // Mapa listy kategorii na listę DTO
    public static List<CategoryDTO> toDTOList(List<Category> categories) {
        return categories.stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
