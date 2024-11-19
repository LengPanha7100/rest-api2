package com.example.demospring.restapi2.service;

import com.example.demospring.restapi2.model.Events;
import com.example.demospring.restapi2.model.dto.EventsRequest;

import java.util.List;

public interface EventService {
    List<Events> getAllEvents(Integer pageNo , Integer pageSize);

    Events getEventsById(Long id);

    Events createEvents(EventsRequest eventsRequest);

    Events updateEvents(EventsRequest eventsRequest, Long id);

    Events deleteEvents(Long id);
}
