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
 * Queue
 */
@Entity
@Table(name = "queues")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-22T19:51:05.893207800+03:00[Europe/Moscow]")
public class Queue   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("players_ids")
  @Valid
  private List<Integer> playersIds = new ArrayList<>();

  @JsonProperty("game_id")
  private Integer gameId;

  public Queue id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор очереди
   * @return id
  */
  @ApiModelProperty(example = "1", required = true, value = "Уникальный идентификатор очереди")
  @Nonnull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Queue playersIds(List<Integer> playersIds) {
    this.playersIds = playersIds;
    return this;
  }

  public Queue addPlayersIdsItem(Integer playersIdsItem) {
    this.playersIds.add(playersIdsItem);
    return this;
  }

  /**
   * id игроков, находящихся в очереди
   * @return playersIds
  */
  @ApiModelProperty(example = "[5,6,7]", required = true, value = "id игроков, находящихся в очереди")
  @Nonnull


  public List<Integer> getPlayersIds() {
    return playersIds;
  }

  public void setPlayersIds(List<Integer> playersIds) {
    this.playersIds = playersIds;
  }

  public Queue gameId(Integer gameId) {
    this.gameId = gameId;
    return this;
  }

  /**
   * id игры, на которую стоит очередь
   * @return gameId
  */
  @ApiModelProperty(example = "1", required = true, value = "id игры, на которую стоит очередь")
  @Nonnull


  public Integer getGameId() {
    return gameId;
  }

  public void setGameId(Integer gameId) {
    this.gameId = gameId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Queue queue = (Queue) o;
    return Objects.equals(this.id, queue.id) &&
        Objects.equals(this.playersIds, queue.playersIds) &&
        Objects.equals(this.gameId, queue.gameId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, playersIds, gameId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Queue {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    playersIds: ").append(toIndentedString(playersIds)).append("\n");
    sb.append("    gameId: ").append(toIndentedString(gameId)).append("\n");
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

