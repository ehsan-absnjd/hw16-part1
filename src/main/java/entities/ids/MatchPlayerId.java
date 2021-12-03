package entities.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MatchPlayerId implements Serializable {
    Integer matchId;
    Integer playerId;

    public MatchPlayerId() {
    }

    public MatchPlayerId(Integer matchId, Integer playerId) {
        this.matchId = matchId;
        this.playerId = playerId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public Integer getPlayerId() {
        return playerId;
    }
}
