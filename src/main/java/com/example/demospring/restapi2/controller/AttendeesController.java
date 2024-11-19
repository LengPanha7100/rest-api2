package com.example.demospring.restapi2.controller;

import com.example.demospring.restapi2.model.APIResponse;
import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.dto.AttendeesRequest;
import com.example.demospring.restapi2.service.AttendeesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeesController {
    private final AttendeesService attendeesService;

    public AttendeesController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Attendees>>> getAllAttendees(@RequestParam (defaultValue = "1") Integer pageNo,
                                                                        @RequestParam (defaultValue = "10") Integer pageSize){
        List<Attendees> attendees = attendeesService.getAllAttendees(pageNo,pageSize);
        APIResponse<List<Attendees>> apiResponse = APIResponse.<List<Attendees>>builder()
                .message("Get all attendees successfully!")
                .status(HttpStatus.OK)
                .payload(attendees)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Attendees>> getAttendeesById(@PathVariable Long id ){
        Attendees attendees = attendeesService.getAttendeesById(id);
        APIResponse<Attendees> apiResponse = APIResponse.<Attendees>builder()
                .message("Get attendees by id successfully!")
                .status(HttpStatus.OK)
                .payload(attendees)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> createAttendees(@RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees = attendeesService.createAttendees(attendeesRequest);
        APIResponse<Attendees> apiResponse = APIResponse.<Attendees>builder()
                .message("Created attendees successfully!")
                .status(HttpStatus.CREATED)
                .payload(attendees)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendeesById(@PathVariable Long id ,@RequestBody AttendeesRequest attendeesRequest){
        Attendees attendees = attendeesService.updateAttendeesById(id ,attendeesRequest );
        APIResponse<Attendees> apiResponse = APIResponse.<Attendees>builder()
                .message("Updated attendees by id successfully!")
                .status(HttpStatus.OK)
                .payload(attendees)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendees(@PathVariable Long id ){
        Attendees attendees = attendeesService.deleteAttendees(id);
        APIResponse<Attendees> apiResponse = APIResponse.<Attendees>builder()
                .message("Deleted attendees by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
