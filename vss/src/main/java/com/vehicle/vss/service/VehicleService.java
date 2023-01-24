package com.vehicle.vss.service;

import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle getById(Integer id) {
        Optional<Vehicle> vehicle = repository.findById(id);
        return vehicle.orElse(null);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void deleteVehicle(Integer id) {
        repository.deleteById(id);
    }
}
