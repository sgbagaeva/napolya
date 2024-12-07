package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Photo
 */
@Table(name = "photo")
public class Photo {
    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created_at")
    @Column("created_at")
    @DateTimeFormat
    private LocalDateTime createdAt;

    @JsonProperty("description")
    private String description;

    public Photo id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор фотографии
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Photo url(String url) {
        this.url = url;
        return this;
    }

    /**
     * URL фотографии
     * @return url
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Photo createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Дата и время создания фотографии
     * @return createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Photo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Описание фотографии
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Photo photo = (Photo) o;
        return Objects.equals(this.id, photo.id) &&
                Objects.equals(this.url, photo.url) &&
                Objects.equals(this.createdAt, photo.createdAt) &&
                Objects.equals(this.description, photo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, createdAt, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Photo {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" url: ").append(toIndentedString(url)).append("\n");
        sb.append(" createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append(" description: ").append(toIndentedString(description)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n ");
    }
}
