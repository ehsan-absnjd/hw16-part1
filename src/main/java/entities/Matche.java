package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matche implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_team_id")
    private Team hostTeam;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_team_id")
    private Team guestTeam;

    private int hostPoints;

    private int guestPoints;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    public Matche() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public void setHostPoints(int hostPoints) {
        this.hostPoints = hostPoints;
    }

    public void setGuestPoints(int guestPoints) {
        this.guestPoints = guestPoints;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Integer getId() {
        return id;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public int getHostPoints() {
        return hostPoints;
    }

    public int getGuestPoints() {
        return guestPoints;
    }

    public Season getSeason() {
        return season;
    }

    public Stadium getStadium() {
        return stadium;
    }
}
