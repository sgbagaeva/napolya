package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * PlayerQueue
 */
@Table(name = "player_queue")
public class PlayerQueue {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("player_id")
    private Integer playerId;

    @JsonProperty("queue_id")
    private Integer queueId;

    public PlayerQueue id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между игроком и очередью
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlayerQueue playerId(Integer playerId) {
        this.playerId = playerId;
        return this;
    }

    /**
     * ID игрока
     * @return playerId
     */
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public PlayerQueue queueId(Integer queueId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerQueue playerQueue = (PlayerQueue) o;
        return Objects.equals(this.id, playerQueue.id) &&
                Objects.equals(this.playerId, playerQueue.playerId) &&
                Objects.equals(this.queueId, playerQueue.queueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, queueId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlayerQueue {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" playerId: ").append(toIndentedString(playerId)).append("\n");
        sb.append(" queueId: ").append(toIndentedString(queueId)).append("\n");
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
