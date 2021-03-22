package com.mwitkowski.footballapi.converter;

import com.mwitkowski.footballapi.models.dto.ClubDTO;
import com.mwitkowski.footballapi.models.entity.club.Club;
import com.mwitkowski.footballapi.models.entity.league.League;
import com.mwitkowski.footballapi.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClubConverter implements Converter<ClubDTO, Club> {
    private LeagueRepository leagueRepository;

    @Autowired
    public ClubConverter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Club convert(ClubDTO clubDTO) {
        Club club = new Club();
        club.setClubName(clubDTO.getClubName());
        club.setCity(clubDTO.getCity());
        club.setFoundationYear(clubDTO.getFoundationYear());
        if(Objects.nonNull(clubDTO.getId())){
            club.setId(clubDTO.getId());
        }

        if(Objects.nonNull(clubDTO.getLeagueId())){
            League clubLeague = leagueRepository.findById(clubDTO.getLeagueId())
                    .orElseThrow(()-> new IllegalArgumentException("BRAK LIGI"));
            club.setLeague(clubLeague);
        }
        return club;
    }
}
