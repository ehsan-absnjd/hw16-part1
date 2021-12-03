package repositories;

import entities.CoachSeason;
import entities.ids.CoachSeasonId;

public class CoachSeasonRepository extends BaseRepository<CoachSeason , CoachSeasonId> {
    @Override
    protected void setEntityClass() {
        entityClass=CoachSeason.class;
    }
}
