package entities;

import entities.ids.CoachSeasonId;

import javax.persistence.*;

@Entity
public class CoachSeason implements BaseEntity<CoachSeasonId> {
    @EmbeddedId
    private CoachSeasonId id;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "coach_id")
    @MapsId("coachId")
    private Coach coach;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    @MapsId("seasonId")
    private Season season;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "team_id")
    private Team team;

    private Long salary;

    public CoachSeason() {
    }

    public void setId(CoachSeasonId id) {
        this.id = id;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
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

    public CoachSeasonId getId() {
        return id;
    }

    public Coach getCoach() {
        return coach;
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

    @Override
    public String toString() {
        return "CoachSeason{" +
                "coach=" + coach +
                ", season=" + season +
                ", team=" + team +
                ", salary=" + salary +
                '}';
    }
}

