package pl.dkowalczyk.polsatsportclone.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true, updatable = true)
    private String title;

    @Column(nullable = false, length = 100, unique = true, updatable = true)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be in the format: example-slug-here")
    private String slug;

    private String excerpt;
    private String content;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "modification_date")
    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    private String url;
    private String imageUrl;
    private String thumbnailUrl;


    @ManyToMany
    @JoinTable(
            name = "news_tags",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
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
}

