package pl.dkowalczyk.polsatsportclone.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TagDTO {
    private Long id;
    private String name;

    // Two-argument constructor used internally (not annotated)
    public TagDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Single-argument constructor for JSON deserialization
    @JsonCreator
    public TagDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    // Default constructor for Jackson
    public TagDTO() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
