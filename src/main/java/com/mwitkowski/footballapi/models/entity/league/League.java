package com.mwitkowski.footballapi.models.entity.league;

import com.mwitkowski.footballapi.models.entity.club.Club;

import javax.persistence.*;
import java.util.List;

@Entity
public class League {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String leagueName;
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "league")
    List<Club> clubs;

    public League() {
    }

    public League(Long id, String leagueName, Country country, List<Club> clubs) {
        this.id = id;
        this.leagueName = leagueName;
        this.country = country;
        this.clubs = clubs;
    }

    public Long getId() {
        return id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Country getCountry() {
        return country;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
}
