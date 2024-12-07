package com.example.napolya.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * PlayerTeam
 */
@Table(name = "player_team")
public class PlayerTeam {

    @Id
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("player_id")
    private Integer playerId;

    @JsonProperty("team_id")
    private Integer teamId;

    public PlayerTeam id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Уникальный идентификатор связи между игроком и командой
     * @return id
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlayerTeam playerId(Integer playerId) {
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

    public PlayerTeam teamId(Integer teamId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerTeam playerTeam = (PlayerTeam) o;
        return Objects.equals(this.id, playerTeam.id) &&
                Objects.equals(this.playerId, playerTeam.playerId) &&
                Objects.equals(this.teamId, playerTeam.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, teamId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlayerTeam {\n");
        sb.append(" id: ").append(toIndentedString(id)).append("\n");
        sb.append(" playerId: ").append(toIndentedString(playerId)).append("\n");
        sb.append(" teamId: ").append(toIndentedString(teamId)).append("\n");
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

