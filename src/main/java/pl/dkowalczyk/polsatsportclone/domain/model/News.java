package pl.dkowalczyk.polsatsportclone.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true, updatable = true)
    @NotBlank(message = "Tytuł jest wymagany")
    private String title;

    @Column(nullable = false, length = 100, unique = true, updatable = true)
    @NotBlank(message = "Slug jest wymagany")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug musi być w formacie: example-slug-here")
    private String slug;

    @NotBlank(message = "Excerpt jest wymagany")
    private String excerpt;

    @NotBlank(message = "Content jest wymagany")
    private String content;

    @Column(name = "publish_date")
    @NotNull(message = "Data publikacji jest wymagana")
    private LocalDate publishDate;

    @Column(name = "modification_date")
    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull(message = "Autor jest wymagany")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Kategoria jest wymagana")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    private String url;

    @NotBlank(message = "Obrazek jest wymagany")
    private String imageUrl;

    @NotBlank(message = "Miniaturka jest wymagana")
    private String thumbnailUrl;

    @ManyToMany
    @JoinTable(
            name = "news_tags",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @NotEmpty(message = "Tagi są wymagane")
    private List<Tag> tags;

    @Column(name = "is_hot")
    private boolean isHot;

    @Column(name = "is_featured")
    private boolean isFeatured;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewsGalleryImage> gallery;

    @ElementCollection
    @CollectionTable(name = "news_quotes", joinColumns = @JoinColumn(name = "news_id"))
    private List<NewsQuote> quotes;



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

    public @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be in the format: example-slug-here") String getSlug() {
        return slug;
    }

    public void setSlug(@Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be in the format: example-slug-here") String slug) {
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public List<NewsGalleryImage> getGallery() {
        return gallery;
    }

    public void setGallery(List<NewsGalleryImage> gallery) {
        this.gallery = gallery;
    }

    public List<NewsQuote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<NewsQuote> quotes) {
        this.quotes = quotes;
    }
}

