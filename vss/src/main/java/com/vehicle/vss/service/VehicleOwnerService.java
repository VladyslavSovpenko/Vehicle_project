package com.vehicle.vss.service;

import com.vehicle.vss.entity.VehicleOwner;
import com.vehicle.vss.repository.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleOwnerService {

    @Autowired
    private VehicleOwnerRepository repository;

    public VehicleOwner getById(Integer id) {
        Optional<VehicleOwner> vehicleOwner = repository.findById(id);
        return vehicleOwner.orElse(null);
    }

    public List<VehicleOwner> getAllVehiclesOwners() {
        return repository.findAll();
    }

    public VehicleOwner createVO(VehicleOwner vehicleOwner) {
        return repository.save(vehicleOwner);
    }

    public VehicleOwner updateVO(VehicleOwner vehicleOwner) {
        return repository.save(vehicleOwner);
    }

    public void deleteVO(Integer id) {
        repository.deleteById(id);
    }
}
