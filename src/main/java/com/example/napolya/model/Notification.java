package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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

import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Notification
 */
@Entity
@Table(name = "notifications")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class Notification   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("text")
  private String text;

  @JsonProperty("type")
  private String type;

  @JsonProperty("recipient_id")
  private Integer recipientId;

  /**
   * Статус уведомления
   */
  public enum StatusEnum {
    UNREAD("непрочитанное"),
    READ("прочитанное");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime date;

  public Notification id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор уведомления
   * @return id
  */
  @ApiModelProperty(example = "1", required = true, value = "Уникальный идентификатор уведомления")
  @Nonnull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Notification text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Текст уведомления
   * @return text
  */
  @ApiModelProperty(example = "Вы записаны в команду A!", required = true, value = "Текст уведомления")
  @Nonnull


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Notification type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Тип уведомления
   * @return type
  */
  @ApiModelProperty(example = "уведомление о составе команды", required = true, value = "Тип уведомления")
  @Nonnull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Notification recipientId(Integer recipientId) {
    this.recipientId = recipientId;
    return this;
  }

  /**
   * id получателя уведомления
   * @return recipientId
  */
  @ApiModelProperty(example = "2", required = true, value = "id получателя уведомления")
  @Nonnull


  public Integer getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(Integer recipientId) {
    this.recipientId = recipientId;
  }

  public Notification status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Статус уведомления
   * @return status
  */
  @ApiModelProperty(example = "непрочитанное", required = true, value = "Статус уведомления")
  @Nonnull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Notification date(LocalDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Дата и время отправки уведомления
   * @return date
  */
  @ApiModelProperty(example = "2024-11-16T10:00Z", required = true, value = "Дата и время отправки уведомления")
  @Nonnull

  @Valid

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Notification notification = (Notification) o;
    return Objects.equals(this.id, notification.id) &&
        Objects.equals(this.text, notification.text) &&
        Objects.equals(this.type, notification.type) &&
        Objects.equals(this.recipientId, notification.recipientId) &&
        Objects.equals(this.status, notification.status) &&
        Objects.equals(this.date, notification.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, type, recipientId, status, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    recipientId: ").append(toIndentedString(recipientId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

