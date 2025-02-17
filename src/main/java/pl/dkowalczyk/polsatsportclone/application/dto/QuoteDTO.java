package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuoteDTO {
    private String text;
    private String author;
    private String position;
}