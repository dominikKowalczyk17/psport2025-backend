package pl.dkowalczyk.polsatsportclone.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class NewsQuote {
    private String text;
    private String author;
    private String position;

    public NewsQuote(String text, String author, String position) {
        this.text = text;
        this.author = author;
        this.position = position;
    }

    public NewsQuote() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
