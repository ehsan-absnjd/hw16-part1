package repositories;

import entities.Team;

public class TeamRepository extends BaseRepository<Team, Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=Team.class;
    }
}
