package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    private String title;
    private String href;
    private List<SubCategoryDTO> submenu;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String title, String href, List<SubCategoryDTO> submenu) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.submenu = submenu;
    }
}

