package repositories;

import entities.Matche;

public class MatcheRepository extends BaseRepository<Matche,Integer> {
    @Override
    protected void setEntityClass() {
        entityClass=Matche.class;
    }
}
