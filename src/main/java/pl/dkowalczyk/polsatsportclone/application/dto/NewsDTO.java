package pl.dkowalczyk.polsatsportclone.application.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewsDTO {
    private Long id;
    private String title;
    private String slug;
    private String excerpt;
    private String content;
    private LocalDate publishedDate;
    private LocalDate modifiedDate;
    private AuthorDTO author;
    private CategoryDTO category;
    private SubCategoryDTO subCategory;
    private String url;
    private String imageUrl;
    private String thumbnailUrl;
    private List<TagDTO> tags;
    private boolean isHot;
    private boolean isFeatured;
    private List<GalleryDTO> gallery;
    private List<QuoteDTO> quotes;

    public NewsDTO(Long id, String title, String slug, String excerpt, String content, LocalDate publishedDate, LocalDate modifiedDate, AuthorDTO author, CategoryDTO category, SubCategoryDTO subCategory, String url, String imageUrl, String thumbnailUrl, List<TagDTO> tags, boolean isHot, boolean isFeatured, List<GalleryDTO> gallery, List<QuoteDTO> quotes) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.excerpt = excerpt;
        this.content = content;
        this.publishedDate = publishedDate;
        this.modifiedDate = modifiedDate;
        this.author = author;
        this.category = category;
        this.subCategory = subCategory;
        this.url = url;
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.tags = tags;
        this.isHot = isHot;
        this.isFeatured = isFeatured;
        this.gallery = gallery;
        this.quotes = quotes;
    }
}
