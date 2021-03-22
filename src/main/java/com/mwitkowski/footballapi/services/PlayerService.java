package com.mwitkowski.footballapi.services;

import com.mwitkowski.footballapi.converter.PlayerConverter;
import com.mwitkowski.footballapi.models.dto.PlayerDTO;
import com.mwitkowski.footballapi.models.entity.player.Player;
import com.mwitkowski.footballapi.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private PlayerConverter playerConverter;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerConverter playerConverter) {

        this.playerRepository = playerRepository;
        this.playerConverter = playerConverter;
    }

    public Iterable<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id){
        return playerRepository.findById(id);
    }

    public Player save(PlayerDTO playerDTO){
        Player player = playerConverter.convert(playerDTO);
        return playerRepository.save(player);
    }
    public void deleteById(Long id){
        playerRepository.deleteById(id);
    }

}
