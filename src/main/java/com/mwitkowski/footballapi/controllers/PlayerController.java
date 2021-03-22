package com.mwitkowski.footballapi.controllers;

import com.mwitkowski.footballapi.models.dto.PlayerDTO;
import com.mwitkowski.footballapi.models.entity.player.Player;
import com.mwitkowski.footballapi.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ApiOperation(value = "Get all players.")
    @GetMapping
    public ResponseEntity<Iterable<Player>> getAll(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @ApiOperation(value = "Find player by Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> getById(@ApiParam(example = "1") @PathVariable Long id){
        return  ResponseEntity.ok(playerService.findById(id));
    }

    @ApiOperation(value = "Insert new player to database.")
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerDTO playerDTO){
        Player createdPlayer = playerService.save(playerDTO);
        return ResponseEntity.created(URI.create("/"+ createdPlayer.getId())).body(createdPlayer);
    }
    @ApiOperation(value = "Update player information.")
    @PutMapping
    public Player  updatePlayer(@RequestBody PlayerDTO updatedPlayer){
        return playerService.save(updatedPlayer);
    }

    @ApiOperation(value = "Delete player of given Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@ApiParam(example = "2") @PathVariable Long id){
        playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> illegalArgumentExceptionHandler(IllegalArgumentException ex)
    {
        return ResponseEntity.notFound().build();
    }

}
