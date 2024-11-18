package com.example.demospring.restapi2.service.serviceImp;

import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;
import com.example.demospring.restapi2.repository.VenuesRepository;
import com.example.demospring.restapi2.service.VenuesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenuesServiceImp implements VenuesService {
    private final VenuesRepository venuesRepository;

    public VenuesServiceImp(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }

    @Override
    public List<Venues> getAllVenues() {
        return venuesRepository.getAllVenues();
    }

    @Override
    public Venues getVenuesById(Long id) {
        return venuesRepository.getVenuesById(id);
    }

    @Override
    public Venues createVenues(VenuesRequest venuesRequest) {
        return venuesRepository.createVenues(venuesRequest);
    }

    @Override
    public Venues updateVenues(VenuesRequest venuesRequest, Long id) {
        return venuesRepository.updateVenues(venuesRequest,id);
    }

    @Override
    public void deleteVenues(Long id) {
        venuesRepository.deleteVenues(id);
    }
}
