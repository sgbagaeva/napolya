package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * Team
 */
@Table(name = "team")
public class Team {
    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("game_id")
    private Integer gameId;

    @JsonProperty("captain_id")
    private Integer captainId;

    public Team id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор команды
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Название команды
     * @return name
     */
    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team gameId(Integer gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * ID игры, к которой принадлежит команда
     * @return gameId
     */
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Team captainId(Integer captainId) {
        this.captainId = captainId;
        return this;
    }

    /**
     * ID капитана команды
     * @return captainId
     */
    public Integer getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Integer captainId) {
        this.captainId = captainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(this.id, team.id) &&
                Objects.equals(this.name, team.name) &&
                Objects.equals(this.gameId, team.gameId) &&
                Objects.equals(this.captainId, team.captainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gameId, captainId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Team {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" name: ").append(toIndentedString(name)).append("\n");
        sb.append(" gameId: ").append(toIndentedString(gameId)).append("\n");
        sb.append(" captainId: ").append(toIndentedString(captainId)).append("\n");
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

