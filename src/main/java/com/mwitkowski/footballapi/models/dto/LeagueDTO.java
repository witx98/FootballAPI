package com.mwitkowski.footballapi.models.dto;

import com.mwitkowski.footballapi.models.entity.league.Country;

public class LeagueDTO {
    private Long id;
    private String leagueName;
    private Country country;

    public Long getId() {
        return id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Country getCountry() {
        return country;
    }
}
