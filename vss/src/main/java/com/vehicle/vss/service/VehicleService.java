package com.vehicle.vss.service;

import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicles(){
       return repository.findAll();
    }

}
