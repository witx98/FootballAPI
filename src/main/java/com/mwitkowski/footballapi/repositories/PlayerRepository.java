package com.mwitkowski.footballapi.repositories;

import com.mwitkowski.footballapi.models.entity.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
