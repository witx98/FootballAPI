package com.mwitkowski.footballapi.converter;

import com.mwitkowski.footballapi.models.dto.LeagueDTO;
import com.mwitkowski.footballapi.models.entity.club.Club;
import com.mwitkowski.footballapi.models.entity.league.League;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class LeagueConverter implements Converter<LeagueDTO, League> {

    @Override
    public League convert(LeagueDTO leagueDTO) {
        League league = new League();
        league.setLeagueName(leagueDTO.getLeagueName());
        league.setCountry(leagueDTO.getCountry());

        if(Objects.nonNull(leagueDTO.getId())){
            league.setId(leagueDTO.getId());
        }

        return league;
    }
}
