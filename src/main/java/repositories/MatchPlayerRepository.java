package repositories;

import entities.MatchPlayer;
import entities.ids.MatchPlayerId;

public class MatchPlayerRepository extends BaseRepository<MatchPlayer, MatchPlayerId> {
    @Override
    protected void setEntityClass() {
        entityClass=MatchPlayer.class;
    }
}
