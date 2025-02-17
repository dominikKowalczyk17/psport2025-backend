package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SubCategoryDTO {
    private String title;
    private String href;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(String title, String href) {
        this.title = title;
        this.href = href;
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
}
