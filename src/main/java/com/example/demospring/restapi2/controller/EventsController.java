package com.example.demospring.restapi2.controller;

import com.example.demospring.restapi2.model.Events;
import com.example.demospring.restapi2.model.dto.EventsRequest;
import com.example.demospring.restapi2.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
public class EventsController {
    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents (){
        List<Events> eventsList = eventService.getAllEvents();
        return ResponseEntity.ok(eventsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventsById (@PathVariable Long id){
        Events events = eventService.getEventsById(id);
        return ResponseEntity.ok(events);
    }

    @PostMapping
    public ResponseEntity<?> createEvents(@RequestBody EventsRequest eventsRequest){
        Events events = eventService.createEvents(eventsRequest);
        return ResponseEntity.ok(events);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvents(@RequestBody EventsRequest eventsRequest,@PathVariable Long id ){
        Events events = eventService.updateEvents(eventsRequest,id);
        return ResponseEntity.ok(events);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvents(@PathVariable Long id){
        eventService.deleteEvents(id);
        return ResponseEntity.ok("Deleted events by id successfully!");
    }
}
