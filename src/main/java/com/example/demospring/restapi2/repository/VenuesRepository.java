package com.example.demospring.restapi2.repository;

import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenuesRepository {
    @Select(
    """
    SELECT * FROM venues_db;
    """
    )
    @Results(id = "venuesId",value = {
            @Result(property = "venuesName",column = "venues_name")
    })
    List<Venues> getAllVenues();

    @Select(
    """
    INSERT INTO venues_db(venues_name, location)
    values (#{venues.venuesName},#{venues.location})
    RETURNING *;
    """
    )
    @ResultMap("venuesId")
    Venues createVenues(@Param("venues") VenuesRequest venuesRequest);

    @Select(
    """
    SELECT * FROM venues_db WHERE id=#{id};
   """
    )
    @ResultMap("venuesId")
    Venues getVenuesById(Long id);

    @Select(
    """
    UPDATE venues_db
    SET venues_name= #{venues.venuesName}, location = #{venues.location}
    WHERE id=#{id}
    RETURNING *;
    """
    )
    @ResultMap("venuesId")
    Venues updateVenues(@Param("venues") VenuesRequest venuesRequest, Long id);

    @Select("""
    DELETE FROM venues_db WHERE id = #{id};
    """)
    void deleteVenues(Long id);
}
