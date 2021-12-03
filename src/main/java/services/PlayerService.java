package services;

import entities.Player;
import repositories.PlayerRepository;

public class PlayerService extends BaseService<Player,Integer> {
    @Override
    protected void setRepository() {
        repository=new PlayerRepository();
    }
}
