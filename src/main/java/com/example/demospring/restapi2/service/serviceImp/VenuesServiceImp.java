package com.example.demospring.restapi2.service.serviceImp;

import com.example.demospring.restapi2.exception.BadRequestException;
import com.example.demospring.restapi2.model.Venues;
import com.example.demospring.restapi2.model.dto.VenuesRequest;
import com.example.demospring.restapi2.repository.VenuesRepository;
import com.example.demospring.restapi2.service.VenuesService;
import org.apache.commons.lang3.DoubleRange;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;

@Service
public class VenuesServiceImp implements VenuesService {
    private final VenuesRepository venuesRepository;

    public VenuesServiceImp(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }

    @Override
    public List<Venues> getAllVenues(Integer pageNo , Integer pageSize) {
        return venuesRepository.getAllVenues(pageNo,pageSize);
    }

    @Override
    public Venues getVenuesById(Long id) {
        Venues venues = venuesRepository.getVenuesById(id);
        if (venues == null) {
            throw new BadRequestException("Venues by id " + id + "not found");
        }
        return venues;
    }
    @Override
    public Venues createVenues(VenuesRequest venuesRequest) {
        return venuesRepository.createVenues(venuesRequest);
    }

    @Override
    public Venues updateVenues(VenuesRequest venuesRequest, Long id) {
        Venues venues = venuesRepository.updateVenues(venuesRequest,id);
        if(venues == null) {
            throw new BadRequestException("Venues by id " + id + "not found");
        }
        return venues;
    }

    @Override
    public Venues deleteVenues(Long id) {
        Venues venues = venuesRepository.deleteVenues(id);
        if (venues == null) {
            throw new BadRequestException("Venues by id " + id + "not found");
        }
        return venues;
    }
}
