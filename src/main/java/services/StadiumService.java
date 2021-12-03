package services;

import entities.Stadium;
import repositories.StadiumRepository;

public class StadiumService extends BaseService<Stadium, Integer> {
    @Override
    protected void setRepository() {
        repository=new StadiumRepository();
    }
}
