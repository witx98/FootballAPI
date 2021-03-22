package com.mwitkowski.footballapi.repositories;

import com.mwitkowski.footballapi.models.entity.league.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}

