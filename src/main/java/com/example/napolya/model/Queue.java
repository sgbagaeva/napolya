package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * Queue
 */
@Table(name = "queue")
public class Queue {

    @Id
    @JsonProperty("id")
    private Integer id;

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
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Queue gameId(Integer gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * ID игры, к которой принадлежит очередь
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
        Queue queue = (Queue) o;
        return Objects.equals(this.id, queue.id) &&
                Objects.equals(this.gameId, queue.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Queue {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
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
