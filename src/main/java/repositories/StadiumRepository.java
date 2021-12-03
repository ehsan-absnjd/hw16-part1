package repositories;

import entities.Stadium;

public class StadiumRepository extends BaseRepository<Stadium,Integer>{
    @Override
    protected void setEntityClass() {
        entityClass=Stadium.class;
    }
}
