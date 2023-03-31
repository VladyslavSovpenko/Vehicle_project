package com.vehicle.vss.controllers.controller;

import com.vehicle.vss.entity.Vehicle;
import com.vehicle.vss.entity.VehicleOwner;
import com.vehicle.vss.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String getAllVehicle(@RequestParam(name="title", required = false) String param, Model model) {
        model.addAttribute("vehicles", getVehicleList(param));
        return "vehicle";
    }

    @PostMapping("/create")
    public String createVehicle(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3, Vehicle vehicle) {
        vehicleService.createVehicle(vehicle,file1,file2,file3);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable Integer id, Model model) {
        Vehicle vehicleById = vehicleService.getById(id);
        if (vehicleById.getOwner()==null || vehicleById.getOwner().getName()==null){
            VehicleOwner vehicleOwner = new VehicleOwner();
            vehicleOwner.setName("unkown");
            vehicleById.setOwner(vehicleOwner);
        }
        model.addAttribute("vehicle", vehicleById);
        model.addAttribute("images", vehicleById.getImages());
        return "vehicle-info";
    }

    @PutMapping("/edit/{id}")
    public String editVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @PostMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }

    private List<Vehicle> getVehicleList(String title) {
        List<Vehicle> vehicles = vehicleService.getAllVehicles(title).stream()
                .map(vehicle -> {
                    if (vehicle.getOwner() == null || vehicle.getOwner().getName() == null) {
                        VehicleOwner vehicleOwner = new VehicleOwner();
                        vehicleOwner.setName("unkown");
                        vehicle.setOwner(vehicleOwner);
                    }
                    return vehicle;
                })
                .collect(Collectors.toList());
        return vehicles;
    }
}
