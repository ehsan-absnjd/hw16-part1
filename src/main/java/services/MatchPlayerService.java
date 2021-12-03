package services;

import entities.MatchPlayer;
import entities.ids.MatchPlayerId;
import repositories.MatchPlayerRepository;

public class MatchPlayerService extends BaseService<MatchPlayer, MatchPlayerId>{
    @Override
    protected void setRepository() {
        repository=new MatchPlayerRepository();
    }
}
