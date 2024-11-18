package com.example.demospring.restapi2.controller;

import com.example.demospring.restapi2.model.APIResponse;
import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;
import com.example.demospring.restapi2.service.VenuesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
public class VenuesController {
    private final VenuesService venuesService;
    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Venues>>> getAllVenues (){
        List<Venues> venuesList = venuesService.getAllVenues();
        APIResponse<List<Venues>> apiResponse = APIResponse.<List<Venues>>builder()
                .message("Get all venues successfully!")
                .status(HttpStatus.OK)
                .payload(venuesList)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVenuesById(@PathVariable Long id){
        Venues venues = venuesService.getVenuesById(id);
        return ResponseEntity.ok(venues);
    }

    @PostMapping
    public ResponseEntity<?> createVenues(@RequestBody VenuesRequest venuesRequest){
        Venues venues = venuesService.createVenues(venuesRequest);
        return ResponseEntity.ok(venues);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenues(@RequestBody VenuesRequest venuesRequest,@PathVariable Long id){
        Venues venues = venuesService.updateVenues(venuesRequest,id);
        return ResponseEntity.ok(venues);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteVenues(@PathVariable Long id){
        venuesService.deleteVenues(id);
        return ResponseEntity.ok("Deleted venues by id successfully!");
    }
}
