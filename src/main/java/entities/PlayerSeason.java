package entities;

import entities.ids.PlayerSeasonId;

import javax.persistence.*;

@Entity
public class PlayerSeason implements BaseEntity<PlayerSeasonId> {
    @EmbeddedId
    private PlayerSeasonId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    @MapsId("playerId")
    private Player player;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    @MapsId("seasonId")
    private Season season;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    private Long salary;

    public PlayerSeason() {
    }

    @Override
    public void setId(PlayerSeasonId id) {
        this.id = id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public PlayerSeasonId getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Season getSeason() {
        return season;
    }

    public Team getTeam() {
        return team;
    }

    public Long getSalary() {
        return salary;
    }
}
