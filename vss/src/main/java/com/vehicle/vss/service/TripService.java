package com.vehicle.vss.service;

import com.vehicle.vss.entity.Trip;
import com.vehicle.vss.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository repository;

    public List<Trip> getAllTrip() {
        return repository.findAll();
    }

    public Trip getById(Integer id) {
        Optional<Trip> repair = repository.findById(id);
        return repair.orElse(null);
    }

    public List<Trip> getByVehicleId(Integer id) {
       return repository.findTripByVehicleId(id);
    }

    public Trip createTrip(Trip repair) {
        return repository.save(repair);
    }

    public Trip updateTrip(Trip trip) {
        return repository.save(trip);
    }

    public void deleteTrip(Integer id) {
        repository.deleteById(id);
    }
}
