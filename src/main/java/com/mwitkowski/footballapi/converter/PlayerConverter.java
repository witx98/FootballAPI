package com.mwitkowski.footballapi.converter;

import com.mwitkowski.footballapi.models.entity.club.Club;
import com.mwitkowski.footballapi.models.dto.PlayerDTO;
import com.mwitkowski.footballapi.models.entity.player.Player;
import com.mwitkowski.footballapi.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class PlayerConverter implements Converter<PlayerDTO, Player> {

    private ClubRepository clubRepository;

    @Autowired
    public PlayerConverter(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Player convert(PlayerDTO playerDTO) {

        Player player = new Player();
        player.setBirthdayDate(playerDTO.getBirthdayDate());
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        player.setPosition(playerDTO.getPosition());

        if(Objects.nonNull(playerDTO.getId())){
            player.setId(playerDTO.getId());
        }

        if(Objects.nonNull(playerDTO.getClubId())){
            Club playerClub = clubRepository.findById(playerDTO.getClubId())
                    .orElseThrow(() -> new IllegalArgumentException("BRAK KLUBU"));
            player.setClub(playerClub);
        }
        return player;
    }
}
