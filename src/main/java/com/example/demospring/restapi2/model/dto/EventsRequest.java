package com.example.demospring.restapi2.model.dto;

import com.example.demospring.restapi2.model.Venues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsRequest {
    private String eventName;
    private LocalDateTime eventDate;
    private Long venuesId;
    private List<Long> attendeesId;
}
