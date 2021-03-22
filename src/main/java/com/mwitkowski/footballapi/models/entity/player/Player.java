package com.mwitkowski.footballapi.models.entity.player;

import com.mwitkowski.footballapi.models.entity.club.Club;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdayDate;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public Player(Long id, String name, String surname, LocalDate birthdayDate, Position position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdayDate = birthdayDate;
        this.position = position;
    }

    public Player() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
