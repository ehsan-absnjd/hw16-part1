package entities.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlayerSeasonId implements Serializable {
    private Integer playerId;
    private Integer seasonId;

    public PlayerSeasonId() {
    }

    public PlayerSeasonId(Integer plalyerId, Integer seasonId) {
        this.playerId = plalyerId;
        this.seasonId = seasonId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }
}
