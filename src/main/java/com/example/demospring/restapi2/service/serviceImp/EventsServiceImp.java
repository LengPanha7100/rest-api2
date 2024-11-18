package com.example.demospring.restapi2.service.serviceImp;

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
    public List<Events> getAllEvents() {
        return eventsRepository.getAllEvents();
    }

    @Override
    public Events getEventsById(Long id) {
        return eventsRepository.getEventsById(id);
    }

    @Override
    public Events createEvents(EventsRequest eventsRequest) {
        Events events =  eventsRepository.createEvents(eventsRequest);

        for(Long attendeesId : eventsRequest.getAttendeesId()){
            eventsRepository.insertAttendeesIdAndEventId(events.getEventId(),attendeesId);
        }
        return getEventsById(events.getEventId());
    }

    @Override
    public Events updateEvents(EventsRequest eventsRequest, Long id) {
        Events events = eventsRepository.updateEvents(eventsRequest,id);
        eventsRepository.deleteAllAttendeesIdByEventId(id);
        for(Long attendeesId : eventsRequest.getAttendeesId()){
            eventsRepository.insertAttendeesIdAndEventId(events.getEventId(),attendeesId);
        }
        return eventsRepository.updateEvents(eventsRequest,id);
    }

    @Override
    public void deleteEvents(Long id) {
       eventsRepository.deleteEvents(id);
    }
}
