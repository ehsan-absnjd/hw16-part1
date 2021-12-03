package services;

import entities.Team;
import repositories.TeamRepository;

public class TeamService extends BaseService<Team,Integer> {
    @Override
    protected void setRepository() {
        repository=new TeamRepository();
    }
}
