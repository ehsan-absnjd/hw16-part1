package services;

import entities.Coach;
import repositories.CoachRepository;

public class CoachService extends BaseService<Coach,Integer> {
    @Override
    protected void setRepository() {
        repository=new CoachRepository();
    }
}
