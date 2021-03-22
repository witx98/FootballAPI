package com.mwitkowski.footballapi.controllers;

import com.mwitkowski.footballapi.models.dto.LeagueDTO;
import com.mwitkowski.footballapi.models.entity.league.League;
import com.mwitkowski.footballapi.services.LeagueService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {
    private LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @ApiOperation(value = "Get all leagues.")
    @GetMapping
    public ResponseEntity<Iterable<League>> getAll(){
        return ResponseEntity.ok(leagueService.findAll());
    }

    @ApiOperation(value = "Find league by Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<League>> getById(@ApiParam(example = "1") @PathVariable Long id){
        return ResponseEntity.ok(leagueService.findById(id));
    }

    @ApiOperation(value = "Insert new league to database.")
    @PostMapping
    public ResponseEntity<League> addLeague(@RequestBody LeagueDTO leagueDTO){
        League createdLeague = leagueService.save(leagueDTO);
        return ResponseEntity.created(URI.create("/" + createdLeague.getId())).body(createdLeague);
    }

    @ApiOperation(value = "Update league information.")
    @PutMapping
    public League updateLeague(@RequestBody LeagueDTO updatedLeague){
        return leagueService.save(updatedLeague);
    }

    @ApiOperation(value = "Delete league of given Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLeague(@PathVariable Long id){
        leagueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> illegalArgumentExceptionHandler(IllegalArgumentException ex)
    {
        return ResponseEntity.notFound().build();
    }
}
