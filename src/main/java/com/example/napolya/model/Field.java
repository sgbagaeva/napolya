package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Field
 */
@Entity
@Table(name = "fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class Field   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @JsonProperty("games_ids")
  @Valid
  private List<Integer> gamesIds = null;

  public Field id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор поля
   * @return id
  */
  @ApiModelProperty(example = "1", required = true, value = "Уникальный идентификатор поля")
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
  @ApiModelProperty(example = "Арена Спорта", required = true, value = "Название поля")
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
  @ApiModelProperty(example = "Большой стадион с искусственным покрытием для футбольных матчей.", value = "Описание поля")
  @Nullable

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
   * Местоположение поля
   * @return location
  */
  @ApiModelProperty(example = "ул. Спортивная, д. 1, г. Санкт-Петербург", required = true, value = "Местоположение поля")
  @Nonnull


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
   * id провайдера поля
   * @return providerId
  */
  @ApiModelProperty(example = "2", required = true, value = "id провайдера поля")
  @Nonnull


  public Integer getProviderId() {
    return providerId;
  }

  public void setProviderId(Integer providerId) {
    this.providerId = providerId;
  }

  public Field gamesIds(List<Integer> gamesIds) {
    this.gamesIds = gamesIds;
    return this;
  }

  public Field addGamesIdsItem(Integer gamesIdsItem) {
    if (this.gamesIds == null) {
      this.gamesIds = new ArrayList<>();
    }
    this.gamesIds.add(gamesIdsItem);
    return this;
  }

  /**
   * id игр, проводимых на этом поле
   * @return gamesIds
  */
  @ApiModelProperty(example = "[101,102,103]", value = "id игр, проводимых на этом поле")


  public List<Integer> getGamesIds() {
    return gamesIds;
  }

  public void setGamesIds(List<Integer> gamesIds) {
    this.gamesIds = gamesIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Field field = (Field) o;
    return Objects.equals(this.id, field.id) &&
        Objects.equals(this.name, field.name) &&
        Objects.equals(this.description, field.description) &&
        Objects.equals(this.location, field.location) &&
        Objects.equals(this.providerId, field.providerId) &&
        Objects.equals(this.gamesIds, field.gamesIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, location, providerId, gamesIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Field {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    gamesIds: ").append(toIndentedString(gamesIds)).append("\n");
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

