package services;

import entities.PlayerSeason;
import entities.ids.PlayerSeasonId;
import repositories.PlayerSeasonRepository;

public class PlayerSeasonService extends BaseService<PlayerSeason, PlayerSeasonId> {
    @Override
    protected void setRepository() {
        repository = new PlayerSeasonRepository();
    }
}
