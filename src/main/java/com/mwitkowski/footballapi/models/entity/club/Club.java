package com.mwitkowski.footballapi.models.entity.club;

import com.mwitkowski.footballapi.models.entity.league.League;
import com.mwitkowski.footballapi.models.entity.player.Player;

import javax.persistence.*;
import java.util.List;

@Entity
public class Club {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String clubName;
    private int foundationYear;
    @Enumerated(EnumType.STRING)
    private City city;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "club")
    List<Player> players;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public Club() {
    }

    public Club(Long id, String clubName, int foundationYear, City city, List<Player> players) {
        this.id = id;
        this.clubName = clubName;
        this.foundationYear = foundationYear;
        this.city = city;
        this.players = players;
    }


    public Long getId() {
        return id;
    }

    public String getClubName() {
        return clubName;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public City getCity() {
        return city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
