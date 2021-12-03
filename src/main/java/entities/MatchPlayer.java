package entities;

import entities.ids.MatchPlayerId;

import javax.persistence.*;

@Entity
public class MatchPlayer implements  BaseEntity<MatchPlayerId> {
    @EmbeddedId
    private MatchPlayerId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    @MapsId("matchId")
    private Matche match;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    @MapsId("playerId")
    private Player player;

    private int goals;

    public MatchPlayer() {
    }

    public void setId(MatchPlayerId id) {
        this.id = id;
    }

    public void setMatch(Matche match) {
        this.match = match;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public MatchPlayerId getId() {
        return id;
    }

    public Matche getMatch() {
        return match;
    }

    public Player getPlayer() {
        return player;
    }

    public int getGoals() {
        return goals;
    }
}
