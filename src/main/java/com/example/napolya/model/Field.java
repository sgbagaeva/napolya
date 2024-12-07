package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * Field
 */
@Table(name = "field")
public class Field {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("location")
    private String location;

    @JsonProperty("provider_id")
    private Integer providerId;

    public Field id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор поля
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Field name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Название поля
     * @return name
     */
    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Описание поля
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Field location(String location) {
        this.location = location;
        return this;
    }

    /**
     * Локация поля
     * @return location
     */
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Field providerId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    /**
     * ID провайдера поля
     * @return providerId
     */
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Field fieldObj = (Field) o;
        return Objects.equals(this.id, fieldObj.id) &&
                Objects.equals(this.name, fieldObj.name) &&
                Objects.equals(this.description, fieldObj.description) &&
                Objects.equals(this.location, fieldObj.location) &&
                Objects.equals(this.providerId, fieldObj.providerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, location, providerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Field {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" name: ").append(toIndentedString(name)).append("\n");
        sb.append(" description: ").append(toIndentedString(description)).append("\n");
        sb.append(" location: ").append(toIndentedString(location)).append("\n");
        sb.append(" providerId: ").append(toIndentedString(providerId)).append("\n");
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

