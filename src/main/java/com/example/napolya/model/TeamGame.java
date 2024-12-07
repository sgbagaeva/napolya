package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * TeamGame
 */
@Table(name = "team_game")
public class TeamGame {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("team_id")
    private Integer teamId;

    @JsonProperty("game_id")
    private Integer gameId;

    public TeamGame id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между командой и игрой
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeamGame teamId(Integer teamId) {
        this.teamId = teamId;
        return this;
    }

    /**
     * ID команды
     * @return teamId
     */
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public TeamGame gameId(Integer gameId) {
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
        TeamGame teamGame = (TeamGame) o;
        return Objects.equals(this.id, teamGame.id) &&
                Objects.equals(this.teamId, teamGame.teamId) &&
                Objects.equals(this.gameId, teamGame.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamId, gameId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TeamGame {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" teamId: ").append(toIndentedString(teamId)).append("\n");
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

