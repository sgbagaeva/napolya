package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Game
 */
@Table(name = "game")
public class Game   {
  @Id
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("start_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  /**
   * Статус игры
   */

  @JsonProperty("status")
  private String status;

  @JsonProperty("creator_id")
  private Integer creatorId;

  @JsonProperty("field_id")
  private Integer fieldId;

//  @JsonProperty("teams_ids")
//  private List<Integer> teamsIds = null;

  @JsonProperty("queue_id")
  private Integer queueId;


  public Game id(Integer id) {
    this.id = id;
    return this;
  }


  /**
   * Уникальный идентификатор игры
   * @return id
  */
  @Nonnull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Game name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название игры
   * @return name
  */
  @Nonnull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Game description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Описание игры
   * @return description
  */


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Game startDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Дата и время начала игры
   * @return startDate
  */
  @Nonnull

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public Game status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Статус игры
   * @return status
  */


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Game creatorId(Integer creatorId) {
    this.creatorId = creatorId;
    return this;
  }

  /**
   * id администратора, создавшего игру
   * @return creatorId
  */
  @Nonnull


  public Integer getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Integer creatorId) {
    this.creatorId = creatorId;
  }

  public Game fieldId(Integer fieldId) {
    this.fieldId = fieldId;
    return this;
  }

  /**
   * id поля, на котором будет проводиться игра
   * @return fieldId
  */
  @Nonnull


  public Integer getFieldId() {
    return fieldId;
  }

  public void setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
  }
  /*
  public Game teamsIds(List<Integer> teamsIds) {
    this.teamsIds = teamsIds;
    return this;
  }

  public Game addTeamsIdsItem(Integer teamsIdsItem) {
    if (this.teamsIds == null) {
      this.teamsIds = new ArrayList<>();
    }
    this.teamsIds.add(teamsIdsItem);
    return this;
  }
  */
  /**
   * id команд, участвующих в игре
   * @return teamsIds
  */

  /*
  public List<Integer> getTeamsIds() {
    return teamsIds;
  }

  public void setTeamsIds(List<Integer> teamsIds) {
    this.teamsIds = teamsIds;
  }
  */
  public Game queueId(Integer queueId) {
    this.queueId = queueId;
    return this;
  }

  /**
   * id очереди на игру
   * @return queueId
  */


  public Integer getQueueId() {
    return queueId;
  }

  public void setQueueId(Integer queueId) {
    this.queueId = queueId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Game game = (Game) o;
    return Objects.equals(this.id, game.id) &&
        Objects.equals(this.name, game.name) &&
        Objects.equals(this.description, game.description) &&
        Objects.equals(this.startDate, game.startDate) &&
        Objects.equals(this.status, game.status) &&
        Objects.equals(this.creatorId, game.creatorId) &&
        Objects.equals(this.fieldId, game.fieldId) &&
        //Objects.equals(this.teamsIds, game.teamsIds) &&
        Objects.equals(this.queueId, game.queueId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, startDate, status, creatorId, fieldId, /*teamsIds*/ queueId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Game {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
    sb.append("    fieldId: ").append(toIndentedString(fieldId)).append("\n");
    //sb.append("    teamsIds: ").append(toIndentedString(teamsIds)).append("\n");
    sb.append("    queueId: ").append(toIndentedString(queueId)).append("\n");
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

