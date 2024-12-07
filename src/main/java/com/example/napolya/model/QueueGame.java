package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * QueueGame
 */
@Table(name = "queue_game")
public class QueueGame {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("queue_id")
    private Integer queueId;

    @JsonProperty("game_id")
    private Integer gameId;

    public QueueGame id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между очередью и игрой
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QueueGame queueId(Integer queueId) {
        this.queueId = queueId;
        return this;
    }

    /**
     * ID очереди
     * @return queueId
     */
    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public QueueGame gameId(Integer gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * ID игры
     * @return gameId
     */
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
        QueueGame queueGame = (QueueGame) o;
        return Objects.equals(this.id, queueGame.id) &&
                Objects.equals(this.queueId, queueGame.queueId) &&
                Objects.equals(this.gameId, queueGame.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queueId, gameId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueueGame {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" queueId: ").append(toIndentedString(queueId)).append("\n");
        sb.append(" gameId: ").append(toIndentedString(gameId)).append("\n");
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
