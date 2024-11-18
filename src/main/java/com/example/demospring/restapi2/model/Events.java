package com.example.demospring.restapi2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    private Long eventId;
    private String eventName;
    private LocalDateTime eventDate;
    private Venues venues;
    private List<Attendees> attendeesList;
}
