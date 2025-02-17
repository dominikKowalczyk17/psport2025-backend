package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GalleryDTO {
    private String thumbnail;
    private String full;
    private String caption;
}
