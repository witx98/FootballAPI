package com.mwitkowski.footballapi.controllers;

import com.mwitkowski.footballapi.models.dto.ClubDTO;
import com.mwitkowski.footballapi.models.entity.club.Club;
import com.mwitkowski.footballapi.services.ClubService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @ApiOperation(value = "Get all clubs.")
    @GetMapping
    public ResponseEntity<Iterable<Club>> getAll(){
        return ResponseEntity.ok(clubService.findAll());
    }

    @ApiOperation(value = "Find club by id.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Club>> getById(@ApiParam(example = "1") @PathVariable Long id){
        return ResponseEntity.ok(clubService.findById(id));
    }

    @ApiOperation(value = "Insert new club to database")
    @PostMapping
    public ResponseEntity<Club> addClub(@RequestBody ClubDTO clubDTO){
        Club createdClub = clubService.save(clubDTO);
        return ResponseEntity.created(URI.create("/" + createdClub.getId())).body(createdClub);
    }

    @ApiOperation(value = "Update club information.")
    @PutMapping
    public Club updateClub(@RequestBody ClubDTO updatedClub){
        return clubService.save(updatedClub);
    }

    @ApiOperation(value = "Delete club of given Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClub(@ApiParam(example = "2") @PathVariable Long id){
        clubService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> illegalArgumentExceptionHandler(IllegalArgumentException ex)
    {
        return ResponseEntity.notFound().build();
    }
}
