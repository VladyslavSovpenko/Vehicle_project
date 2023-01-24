package com.vehicle.vss.service;

import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.entity.VehicleOwner;
import com.vehicle.vss.repository.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleOwnerService {

    @Autowired
    private VehicleOwnerRepository repository;

    public List<VehicleOwner> getAllVehiclesOwners() {
        return repository.findAll();
    }
}
