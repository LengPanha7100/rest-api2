package com.example.demospring.restapi2.service.serviceImp;

import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.dto.AttendeesRequest;
import com.example.demospring.restapi2.repository.AttendeesRepository;
import com.example.demospring.restapi2.service.AttendeesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeesServiceImp implements AttendeesService {
    private final AttendeesRepository attendeesRepository;

    public AttendeesServiceImp(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    @Override
    public List<Attendees> getAllAttendees() {
        return attendeesRepository.getAllAttendees();
    }

    @Override
    public Attendees getAttendeesById(Long id) {
        return attendeesRepository.getAttendeesById(id);
    }

    @Override
    public Attendees createAttendees(AttendeesRequest attendeesRequest) {
        return attendeesRepository.createAttendees(attendeesRequest);
    }

    @Override
    public Attendees updateAttendeesById(Long id, AttendeesRequest attendeesRequest) {
        return attendeesRepository.updateAttendees(id,attendeesRequest);
    }

    @Override
    public void deleteAttendees(Long id) {
       attendeesRepository.deleteAttendees(id);
    }
}
