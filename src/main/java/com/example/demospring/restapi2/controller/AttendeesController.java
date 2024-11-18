package com.example.demospring.restapi2.controller;

import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.dto.AttendeesRequest;
import com.example.demospring.restapi2.service.AttendeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeesController {
    private final AttendeesService attendeesService;

    public AttendeesController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAttendees(){
        List<Attendees> attendees = attendeesService.getAllAttendees();
        return ResponseEntity.ok(attendees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendeesById(@PathVariable Long id ){
        Attendees attendees = attendeesService.getAttendeesById(id);
        return ResponseEntity.ok(attendees);
    }

    @PostMapping
    public ResponseEntity<?> createAttendees(@RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees = attendeesService.createAttendees(attendeesRequest);
        return ResponseEntity.ok(attendees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendeesById(@PathVariable Long id ,@RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees = attendeesService.updateAttendeesById(id ,attendeesRequest );
        return ResponseEntity.ok(attendees);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendees(@PathVariable Long id ){
        attendeesService.deleteAttendees(id);
        return ResponseEntity.ok("Deleted attendees by is successfully!");
    }
}
