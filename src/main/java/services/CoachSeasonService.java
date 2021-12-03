package services;

import entities.CoachSeason;
import entities.ids.CoachSeasonId;
import repositories.CoachSeasonRepository;

public class CoachSeasonService extends BaseService<CoachSeason, CoachSeasonId> {
    @Override
    protected void setRepository() {
        repository=new CoachSeasonRepository();
    }
}
