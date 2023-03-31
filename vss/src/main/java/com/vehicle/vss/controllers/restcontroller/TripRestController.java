package com.vehicle.vss.controllers.restcontroller;

import com.vehicle.vss.entity.Trip;
import com.vehicle.vss.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TripRestController {

    @Autowired
    private TripService service;

    @GetMapping("/trips")
    public List<Trip> getAllRepair() {
        return service.getAllTrip();
    }

    @GetMapping("/trips/{id}")
    public Trip getRepairById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/trips/vehicle/{id}")
    public List<Trip> getTripsByVehicleId(@PathVariable Integer id){
        return service.getByVehicleId(id);
    }

    @PutMapping("/trips")
    public Trip updateRepair(@RequestBody Trip trip) {
        return service.updateTrip(trip);
    }

    @PostMapping("/trips")
    public Trip createRepair(@RequestBody Trip trip) {
        return service.createTrip(trip);
    }

    @DeleteMapping("/trips/{id}")
    public String deleteTrip(@PathVariable Integer id) {
        if (service.getById(id) == null)
            return "There is no Trip with id " + id + " in DataBase";
        service.deleteTrip(id);
        return "Trip with id " + id + " was deleted";
    }
}
