package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Field
 */
@Entity
@Table(name = "photos")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class Photo   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("url")
    private URL url;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("description")
    private String description;


    /**
     * Уникальный идентификатор фото
     * @return id
     */
    @Nonnull


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Photo url(URL url) {
        this.url = url;
        return this;
    }

    /**
     * URL фото
     * @return url
     */
    @Nonnull


    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Photo createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Дата создания фото
     * @return createdAt
     */
    @Nonnull


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
     * Описание фото
     * @return description
     */
    @Nullable

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
        sb.append("class Field {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
        return o.toString().replace("\n", "\n    ");
    }
}


