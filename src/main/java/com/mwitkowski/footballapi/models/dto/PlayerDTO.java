package com.mwitkowski.footballapi.models.dto;

import com.mwitkowski.footballapi.models.entity.player.Position;

import java.time.LocalDate;

public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdayDate;
    private Position position;
    private Long clubId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public Position getPosition() {
        return position;
    }

    public Long getClubId() {
        return clubId;
    }
}
