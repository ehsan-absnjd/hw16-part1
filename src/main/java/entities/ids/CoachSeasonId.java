package entities.ids;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CoachSeasonId implements Serializable {
    private Integer coachId;
    private Integer seasonId;

    public CoachSeasonId() {
    }

    public CoachSeasonId(Integer coachId, Integer seasonId) {
        this.coachId = coachId;
        this.seasonId = seasonId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }
}
