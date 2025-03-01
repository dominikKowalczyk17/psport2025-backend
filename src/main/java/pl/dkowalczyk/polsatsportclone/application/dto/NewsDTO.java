package pl.dkowalczyk.polsatsportclone.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewsDTO {

    private Long id;

    @NotBlank(message = "Tytuł jest wymagany")
    private String title;

    @NotBlank(message = "Slug jest wymagany")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug musi być w formacie: example-slug-here")
    private String slug;

    @NotBlank(message = "Excerpt jest wymagany")
    private String excerpt;

    @NotBlank(message = "Content jest wymagany")
    private String content;

    @NotNull(message = "Data publikacji jest wymagana")
    private LocalDate publishedDate;

    private LocalDate modifiedDate;

    @NotNull(message = "Autor jest wymagany")
    private AuthorDTO author;

    @NotNull(message = "Kategoria jest wymagana")
    private CategoryDTO category;

    private SubCategoryDTO subCategory;

    @NotBlank(message = "URL jest wymagany")
    private String url;

    @NotBlank(message = "Obrazek jest wymagany")
    private String imageUrl;

    @NotBlank(message = "Miniaturka jest wymagana")
    private String thumbnailUrl;

    @NotEmpty(message = "Tagi są wymagane")
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public SubCategoryDTO getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryDTO subCategory) {
        this.subCategory = subCategory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public boolean isHot() {
        return isHot;
    }

    @JsonProperty("isHot")
    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public List<GalleryDTO> getGallery() {
        return gallery;
    }

    public void setGallery(List<GalleryDTO> gallery) {
        this.gallery = gallery;
    }

    public List<QuoteDTO> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<QuoteDTO> quotes) {
        this.quotes = quotes;
    }
}
