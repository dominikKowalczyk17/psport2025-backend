package pl.dkowalczyk.polsatsportclone.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "news_gallery_image")
public class NewsGalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    private String thumbnail;
    private String fullImage;
    private String caption;

    public NewsGalleryImage() {
    }

    public NewsGalleryImage(Long id, News news, String thumbnail, String fullImage, String caption) {
        this.id = id;
        this.news = news;
        this.thumbnail = thumbnail;
        this.fullImage = fullImage;
        this.caption = caption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
