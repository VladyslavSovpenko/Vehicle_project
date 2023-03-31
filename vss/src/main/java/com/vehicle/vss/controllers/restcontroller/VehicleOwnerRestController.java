package com.vehicle.vss.controllers.restcontroller;

import com.vehicle.vss.entity.VehicleOwner;
import com.vehicle.vss.service.VehicleOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleOwnerRestController {

    @Autowired
    private VehicleOwnerService service;

    @GetMapping("/vehicleOwners/{id}")
    public VehicleOwner getVOByID(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/vehicleOwners")
    public List<VehicleOwner> getAllVehicleOwners() {
        return service.getAllVehiclesOwners();
    }

    @PostMapping("/vehicleOwners")
    public VehicleOwner createVO(@RequestBody VehicleOwner vehicleOwner) {
        return service.createVO(vehicleOwner);
    }

    @PutMapping("/vehicleOwners")
    public VehicleOwner putVO(@RequestBody VehicleOwner vehicleOwner) {
        return service.updateVO(vehicleOwner);
    }

    @DeleteMapping("/vehicleOwners/{id}")
    public String deleteVO(@PathVariable Integer id) {
        VehicleOwner vehicleOwner = service.getById(id);
        if (vehicleOwner == null) {
             return  "There is no Vehicle Owner with id " + id + " in DataBase";
        }
        service.deleteVO(id);

        return "Vehicle Owner with id " + id + " was deleted";
    }
}
