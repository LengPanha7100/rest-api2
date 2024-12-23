package com.example.demospring.restapi2.service;

import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.dto.AttendeesRequest;

import java.util.List;

public interface AttendeesService {
    List<Attendees> getAllAttendees(Integer pageNo , Integer pageSize);

    Attendees getAttendeesById(Long id);

    Attendees createAttendees(AttendeesRequest attendeesRequest);

    Attendees updateAttendeesById(Long id, AttendeesRequest attendeesRequest);

    Attendees  deleteAttendees(Long id);
}
