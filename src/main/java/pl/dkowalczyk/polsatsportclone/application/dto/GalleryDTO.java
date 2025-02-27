package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class GalleryDTO {
    private String thumbnail;
    private String full;
    private String caption;

    public GalleryDTO() {
    }

    public GalleryDTO(String thumbnail, String full, String caption) {
        this.thumbnail = thumbnail;
        this.full = full;
        this.caption = caption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
