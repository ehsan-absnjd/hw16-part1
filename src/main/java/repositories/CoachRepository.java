package repositories;

import entities.Coach;

public class CoachRepository extends BaseRepository<Coach , Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=Coach.class;
    }
}
