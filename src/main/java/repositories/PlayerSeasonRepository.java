package repositories;

import entities.PlayerSeason;
import entities.ids.PlayerSeasonId;

public class PlayerSeasonRepository extends BaseRepository<PlayerSeason, PlayerSeasonId>{
    @Override
    protected void setEntityClass() {
        entityClass=PlayerSeason.class;
    }
}
