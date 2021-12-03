package entities;

import org.hibernate.engine.spi.CascadeStyle;

import javax.persistence.*;
import java.util.List;

@Entity
public class City implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "city" ,cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Team> teams;

    @OneToMany(mappedBy = "city" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Stadium> stadiums;

    public City() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Stadium> getStadiums() {
        return stadiums;
    }
}
