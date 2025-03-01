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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<SubCategoryDTO> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<SubCategoryDTO> submenu) {
        this.submenu = submenu;
    }
}

