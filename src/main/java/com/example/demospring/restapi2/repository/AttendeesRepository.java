package com.example.demospring.restapi2.repository;
import com.example.demospring.restapi2.model.Attendees;
import com.example.demospring.restapi2.model.dto.AttendeesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeesRepository {
    @Select("""
    SELECT *FROM attendees_db;
    """)
    @Results(id = "attendeesId",value = {
            @Result(property = "attendeesId",column = "attendees_id"),
            @Result(property = "attendeesName",column = "attendees_name")
    })
    List<Attendees> getAllAttendees();
    @Select("""
        INSERT INTO attendees_db(attendees_name, email)
        VALUES (#{attendees.attendeesName},#{attendees.email})
        returning *;
    """)
    @ResultMap("attendeesId")
    Attendees createAttendees(@Param("attendees") AttendeesRequest attendeesRequest);

    @Select("""
    SELECT *FROM attendees_db where attendees_id =#{id};
    """)
    @ResultMap("attendeesId")
    Attendees getAttendeesById(Long id);

    @Select("""
    UPDATE attendees_db
    SET attendees_name = #{attendees.attendeesName}, email = #{attendees.email}
    WHERE attendees_id = #{id}
    returning *
    """)
    @ResultMap("attendeesId")
    Attendees updateAttendees(Long id,@Param("attendees") AttendeesRequest attendeesRequest);

    @Delete("""
    DELETE FROM attendees_db where attendees_id = #{id};
    """)
    void deleteAttendees(Long id);
}
