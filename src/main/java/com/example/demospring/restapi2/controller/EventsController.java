package com.example.demospring.restapi2.controller;

import com.example.demospring.restapi2.model.APIResponse;
import com.example.demospring.restapi2.model.Events;
import com.example.demospring.restapi2.model.dto.EventsRequest;
import com.example.demospring.restapi2.service.EventService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventsController {
    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Events>>> getAllEvents (@RequestParam (defaultValue = "1") Integer pageNo,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize){
        List<Events> eventsList = eventService.getAllEvents(pageNo,pageSize);
        APIResponse<List<Events>> apiResponse = APIResponse.<List<Events>>builder()
                .message("Get all events successfully!")
                .status(HttpStatus.OK)
                .payload(eventsList)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Events>> getEventsById (@PathVariable Long id){
        Events events = eventService.getEventsById(id);
        APIResponse<Events> apiResponse = APIResponse.<Events>builder()
                .message("Get events by id successfully!")
                .status(HttpStatus.OK)
                .payload(events)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Events>> createEvents(@RequestBody EventsRequest eventsRequest){
        Events events = eventService.createEvents(eventsRequest);
        APIResponse<Events> apiResponse = APIResponse.<Events>builder()
                .message("Created attendees successfully!")
                .status(HttpStatus.CREATED)
                .payload(events)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvents(@RequestBody EventsRequest eventsRequest,@PathVariable Long id ){
        Events events = eventService.updateEvents(eventsRequest,id);
        APIResponse<Events> apiResponse = APIResponse.<Events>builder()
                .message("Updated attendees successfully!")
                .status(HttpStatus.OK)
                .payload(events)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvents(@PathVariable Long id){
        Events events =eventService.deleteEvents(id);
        APIResponse<Events> apiResponse = APIResponse.<Events>builder()
                .message("Deleted attendees successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
