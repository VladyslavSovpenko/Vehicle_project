package com.vehicle.vss.controllers.restcontroller;

import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleRestController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles(null);
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {
        return vehicleService.getById(id);
    }

    @PutMapping("/vehicles")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

//    @PostMapping("/vehicles")
//    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
//        return vehicleService.createVehicle(vehicle);
//    }

    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        if (vehicleService.getById(id) == null)
            return "There is no Vehicle with id " + id + " in DataBase";
        vehicleService.deleteVehicle(id);
        return "Vehicle with id " + id + " was deleted";
    }


}
