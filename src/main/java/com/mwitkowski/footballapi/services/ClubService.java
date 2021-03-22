package com.mwitkowski.footballapi.services;

import com.mwitkowski.footballapi.converter.ClubConverter;
import com.mwitkowski.footballapi.models.dto.ClubDTO;
import com.mwitkowski.footballapi.models.entity.club.Club;
import com.mwitkowski.footballapi.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubService {
    private ClubRepository clubRepository;
    private ClubConverter clubConverter;

    @Autowired
    public ClubService(ClubRepository clubRepository, ClubConverter clubConverter) {
        this.clubRepository = clubRepository;
        this.clubConverter = clubConverter;
    }

    public Iterable<Club> findAll(){
        return clubRepository.findAll();
    }

    public Optional<Club> findById(Long id){
        return clubRepository.findById(id);
    }

    public Club save(ClubDTO clubDTO){
        Club club = clubConverter.convert(clubDTO);
        return clubRepository.save(club);
    }
    public void deleteById(Long id){
        clubRepository.deleteById(id);
    }
}
