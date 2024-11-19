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
    public ResponseEntity<APIResponse<List<Venues>>> getAllVenues (
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        List<Venues> venuesList = venuesService.getAllVenues(pageNo,pageSize);
        APIResponse<List<Venues>> apiResponse = APIResponse.<List<Venues>>builder()
                .message("Get all venues successfully!")
                .status(HttpStatus.OK)
                .payload(venuesList)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Venues>> getVenuesById(@PathVariable Long id){
        Venues venues = venuesService.getVenuesById(id);
        APIResponse<Venues> venuesAPIResponse = APIResponse.<Venues>builder()
                .message("Get venues by id is successfully!")
                .status(HttpStatus.OK)
                .payload(venues)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(venuesAPIResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Venues>> createVenues(@RequestBody VenuesRequest venuesRequest){
        Venues venues = venuesService.createVenues(venuesRequest);
        APIResponse<Venues> venuesAPIResponse = APIResponse.<Venues>builder()
                .message("Created venues successfully!")
                .status(HttpStatus.CREATED)
                .payload(venues)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(venuesAPIResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Venues>> updateVenues(@RequestBody VenuesRequest venuesRequest,@PathVariable Long id){
        Venues venues = venuesService.updateVenues(venuesRequest,id);
        APIResponse<Venues> venuesAPIResponse = APIResponse.<Venues>builder()
                .message("Updated venues by id successfully!")
                .status(HttpStatus.OK)
                .payload(venues)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(venuesAPIResponse);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<APIResponse<Venues>> deleteVenues(@PathVariable Long id){
        Venues venues = venuesService.deleteVenues(id);
        APIResponse<Venues> venuesAPIResponse = APIResponse.<Venues>builder()
                .message("Updated venues by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(venuesAPIResponse);
    }
}
