package com.example.demospring.restapi2.service;

import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;

import java.util.List;

public interface VenuesService {
    List<Venues> getAllVenues();

    Venues getVenuesById(Long id);

    Venues createVenues(VenuesRequest venuesRequest);

    Venues updateVenues(VenuesRequest venuesRequest, Long id);

    void deleteVenues(Long id);
}
