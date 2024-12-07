package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * GameField
 */
@Table(name = "game_field")
public class GameField {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("game_id")
    private Integer gameId;

    @JsonProperty("field_id")
    private Integer fieldId;

    public GameField id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между игрой и полем
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GameField gameId(Integer gameId) {
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

    public GameField fieldId(Integer fieldId) {
        this.fieldId = fieldId;
        return this;
    }

    /**
     * ID поля
     * @return fieldId
     */
    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameField gameField = (GameField) o;
        return Objects.equals(this.id, gameField.id) &&
                Objects.equals(this.gameId, gameField.gameId) &&
                Objects.equals(this.fieldId, gameField.fieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameId, fieldId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GameField {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" gameId: ").append(toIndentedString(gameId)).append("\n");
        sb.append(" fieldId: ").append(toIndentedString(fieldId)).append("\n");
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

