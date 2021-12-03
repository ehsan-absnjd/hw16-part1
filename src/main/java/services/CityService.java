package services;

import entities.City;
import repositories.CityRepository;

public class CityService extends BaseService<City,Integer>{

    @Override
    protected void setRepository() {
        repository=new CityRepository();
    }
}
