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
 * Provider
 */
@Entity
@Table(name = "providers")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class Provider   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("fields_ids")
  @Valid
  private List<Integer> fieldsIds = null;

  public Provider id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор провайдера
   * @return id
  */
  @ApiModelProperty(example = "1", required = true, value = "Уникальный идентификатор провайдера")
  @Nonnull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Provider name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название провайдера
   * @return name
  */
  @ApiModelProperty(example = "Поляна", required = true, value = "Название провайдера")
  @Nonnull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Provider fieldsIds(List<Integer> fieldsIds) {
    this.fieldsIds = fieldsIds;
    return this;
  }

  public Provider addFieldsIdsItem(Integer fieldsIdsItem) {
    if (this.fieldsIds == null) {
      this.fieldsIds = new ArrayList<>();
    }
    this.fieldsIds.add(fieldsIdsItem);
    return this;
  }

  /**
   * id полей, которые предоставляет провайдер
   * @return fieldsIds
  */
  @ApiModelProperty(example = "[1,2,3]", value = "id полей, которые предоставляет провайдер")


  public List<Integer> getFieldsIds() {
    return fieldsIds;
  }

  public void setFieldsIds(List<Integer> fieldsIds) {
    this.fieldsIds = fieldsIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Provider provider = (Provider) o;
    return Objects.equals(this.id, provider.id) &&
        Objects.equals(this.name, provider.name) &&
        Objects.equals(this.fieldsIds, provider.fieldsIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fieldsIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Provider {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fieldsIds: ").append(toIndentedString(fieldsIds)).append("\n");
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

