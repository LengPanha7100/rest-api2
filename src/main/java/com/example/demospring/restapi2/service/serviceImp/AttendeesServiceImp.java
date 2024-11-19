package com.example.demospring.restapi2.service.serviceImp;

import com.example.demospring.restapi2.exception.BadRequestException;
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
    public List<Attendees> getAllAttendees(Integer pageNo , Integer pageSize) {
        if(pageNo <1){
            throw new BadRequestException("Can't input the negative number ");
        }
        return attendeesRepository.getAllAttendees(pageNo,pageSize);
    }

    @Override
    public Attendees getAttendeesById(Long id) {
        Attendees attendees = attendeesRepository.getAttendeesById(id);
        if(attendees == null){
            throw new BadRequestException("Attendees by id "+ id + "not found");
        }
        return attendees;
    }

    @Override
    public Attendees createAttendees(AttendeesRequest attendeesRequest) {
        return attendeesRepository.createAttendees(attendeesRequest);
    }

    @Override
    public Attendees updateAttendeesById(Long id, AttendeesRequest attendeesRequest) {
        Attendees attendees =attendeesRepository.updateAttendees(id,attendeesRequest);
        if(attendees == null){
            throw new BadRequestException("Attendees by id "+ id + "not found");
        }
        return attendees;
    }

    @Override
    public Attendees deleteAttendees(Long id) {
       Attendees attendees = attendeesRepository.deleteAttendees(id);
       if(attendees == null){
          throw new BadRequestException("Attendees by id "+ id + "not found");
       }
       return attendees;
    }
}
