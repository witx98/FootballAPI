package com.mwitkowski.footballapi.services;

import com.mwitkowski.footballapi.converter.LeagueConverter;
import com.mwitkowski.footballapi.models.dto.LeagueDTO;
import com.mwitkowski.footballapi.models.entity.league.League;
import com.mwitkowski.footballapi.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeagueService {
    private LeagueRepository leagueRepository;
    private LeagueConverter leagueConverter;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, LeagueConverter leagueConverter) {
        this.leagueRepository = leagueRepository;
        this.leagueConverter = leagueConverter;
    }

    public Iterable<League> findAll(){
        return leagueRepository.findAll();
    }

    public Optional<League> findById(Long id){
        return leagueRepository.findById(id);
    }

    public League save(LeagueDTO leagueDTO){
        League league = leagueConverter.convert(leagueDTO);
        return leagueRepository.save(league);
    }

    public void deleteById(Long id){
        leagueRepository.deleteById(id);
    }
}
