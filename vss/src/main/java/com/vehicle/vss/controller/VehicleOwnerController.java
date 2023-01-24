package com.vehicle.vss.controller;

import com.vehicle.vss.entity.VehicleOwner;
import com.vehicle.vss.service.VehicleOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleOwnerController {

    @Autowired
    private VehicleOwnerService service;

    @GetMapping("/vehicleOwners")
    public List<VehicleOwner> getAllVehicleOwners() {
        return service.getAllVehiclesOwners();
    }
}
