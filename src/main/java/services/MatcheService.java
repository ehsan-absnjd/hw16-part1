package services;

import entities.Matche;
import repositories.MatcheRepository;

public class MatcheService extends BaseService<Matche,Integer> {
    @Override
    protected void setRepository() {
        repository = new MatcheRepository();
    }
}
