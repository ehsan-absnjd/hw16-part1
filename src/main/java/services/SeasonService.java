package services;

import entities.Season;
import repositories.SeasonRepository;

public class SeasonService extends BaseService<Season,Integer> {
    @Override
    protected void setRepository() {
        repository=new SeasonRepository();
    }
}
