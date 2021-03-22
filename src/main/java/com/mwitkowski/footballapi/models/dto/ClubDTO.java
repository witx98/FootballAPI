package com.mwitkowski.footballapi.models.dto;

import com.mwitkowski.footballapi.models.entity.club.City;

public class ClubDTO {
    private Long id;
    private String clubName;
    private int foundationYear;
    private City city;
    private Long leagueId;

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

    public Long getLeagueId() {
        return leagueId;
    }
}
