package repositories;

import entities.Season;

public class SeasonRepository extends BaseRepository<Season,Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=Season.class;
    }
}
