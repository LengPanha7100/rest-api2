package com.example.demospring.restapi2.service.serviceImp;

import com.example.demospring.restapi2.exception.BadRequestException;
import com.example.demospring.restapi2.model.Events;
import com.example.demospring.restapi2.model.dto.EventsRequest;
import com.example.demospring.restapi2.repository.EventsRepository;
import com.example.demospring.restapi2.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsServiceImp implements EventService {
    private final EventsRepository eventsRepository;

    public EventsServiceImp(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<Events> getAllEvents(Integer pageNo , Integer pageSize) {
        return eventsRepository.getAllEvents(pageNo , pageSize);
    }

    @Override
    public Events getEventsById(Long id) {
        Events events = eventsRepository.getEventsById(id);
        if(events == null){
            throw new BadRequestException("Events by id " + id + " not found ");
        }
        return events;
    }

    @Override
    public Events createEvents(EventsRequest eventsRequest) {
        //get all the events but attendees is null So we loop attendees for to get the object
        Events events =  eventsRepository.createEvents(eventsRequest);
        // check the condition for get object each
        for(Long attendeesId : eventsRequest.getAttendeesId()){
            eventsRepository.insertAttendeesIdAndEventId(events.getEventId(),attendeesId);
        }
        //after you check all ready need to query the eventsById for show the object events
        return getEventsById(events.getEventId());
    }

    @Override
    public Events updateEvents(EventsRequest eventsRequest, Long id) {
        Events events = eventsRepository.updateEvents(eventsRequest,id);
        if(events == null){
            throw new BadRequestException("Events by id " + id + " not found ");
        }
        //need delete attendees first after update event
        eventsRepository.deleteAllAttendeesIdByEventId(id);
        for(Long attendeesId : eventsRequest.getAttendeesId()){
            eventsRepository.insertAttendeesIdAndEventId(events.getEventId(),attendeesId);
        }
        return getEventsById(events.getEventId());
    }

    @Override
    public Events deleteEvents(Long id) {
       Events events = eventsRepository.deleteEvents(id);
        if(events == null){
            throw new BadRequestException("Events by id " + id + " not found ");
        }
        return events;
    }
}
