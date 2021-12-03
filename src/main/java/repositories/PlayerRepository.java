package repositories;

import entities.Player;

public class PlayerRepository extends BaseRepository<Player,Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=Player.class;
    }
}
