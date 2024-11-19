package com.example.demospring.restapi2.service;

import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;

import java.util.List;

public interface VenuesService {
    List<Venues> getAllVenues(Integer pageNo , Integer pageSize);

    Venues getVenuesById(Long id);

    Venues createVenues(VenuesRequest venuesRequest);

    Venues updateVenues(VenuesRequest venuesRequest, Long id);

    Venues deleteVenues(Long id);
}
