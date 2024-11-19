package com.example.demospring.restapi2.repository;

import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.Events;
import com.example.demospring.restapi2.model.dto.EventsRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventsRepository {
    @Results(id = "eventsId",value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venues" , column = "venues_id",
            one = @One(select = "com.example.demospring.restapi2.repository.VenuesRepository.getVenuesById")
            ),
            @Result(property = "attendeesList",column = "event_id",
            many = @Many(select = "getAllAttendeesByEventId")
            )
    })
    @Select("""
    SELECT *FROM events_db
    LIMIT #{pageSize}
    OFFSET #{pageSize} * (#{pageNo} - 1)
    ;
    """)
    List<Events> getAllEvents(Integer pageNo , Integer pageSize);

    @Results(id = "attendeesId",value = {
            @Result(property = "attendeesId",column = "attendees_id"),
            @Result(property = "attendeesName",column = "attendees_name")
    })
    @Select("""
    SELECT a.attendees_id , a.attendees_name , a.email FROM attendees_db a
    JOIN event_attendees_db ead on a.attendees_id = ead.attendees_id
    where event_id = #{eventId};
    """)
    List<Attendees> getAllAttendeesByEventId(Long eventId);
    @Select("""
    INSERT INTO events_db (event_name, event_date, venues_id)
    VALUES (#{events.eventName},#{events.eventDate},#{events.venuesId})
    returning *;
    """)
    @ResultMap("eventsId")
    Events createEvents(@Param("events") EventsRequest eventsRequest);

    @Insert("""
    INSERT INTO event_attendees_db(event_id, attendees_id)
    VALUES (#{eventId},#{attendeesId})
    """)
    @ResultMap("eventsId")
    void insertAttendeesIdAndEventId(Long eventId , Long attendeesId);
    @Select("""
    SELECT *FROM events_db WHERE event_id = #{id};
    """)
    @ResultMap("eventsId")
    Events getEventsById(Long id);

    @Select("""
    UPDATE events_db
    SET event_name = #{event.eventName} , event_date = #{event.eventDate} ,venues_id= #{event.venuesId}
    where event_id = #{id}
    returning *;
    """)
    @ResultMap("eventsId")
    Events updateEvents(@Param("event") EventsRequest eventsRequest, Long id);

    @Delete("""
    DELETE FROM event_attendees_db where event_id = #{eventId};
    """)
    void deleteAllAttendeesIdByEventId(Long eventId);

    @Delete("""
    DELETE FROM events_db where
    event_id= #{id}
    """)
    Events deleteEvents(Long id);
}