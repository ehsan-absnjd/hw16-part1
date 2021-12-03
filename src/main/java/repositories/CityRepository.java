package repositories;

import entities.City;

public class CityRepository extends BaseRepository<City,Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=City.class;
    }
}
