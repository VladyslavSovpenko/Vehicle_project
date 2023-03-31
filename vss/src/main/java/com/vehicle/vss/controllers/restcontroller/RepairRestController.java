package com.vehicle.vss.controllers.restcontroller;

import com.vehicle.vss.entity.Repair;
import com.vehicle.vss.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RepairRestController {

    @Autowired
    private RepairService service;

    @GetMapping("/repairs")
    public List<Repair> getAllRepair() {
        return service.getAllRepair();
    }

    @GetMapping("/repairs/{id}")
    public Repair getRepairById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/repairs")
    public Repair updateRepair(@RequestBody Repair repair) {
        return service.updateRepair(repair);
    }

    @PostMapping("/repairs")
    public Repair createRepair(@RequestBody Repair repair) {
        return service.createRepair(repair);
    }

    @DeleteMapping("/repairs/{id}")
    public String deleteRepair(@PathVariable Integer id) {
        if (service.getById(id) == null)
            return "There is no Repair with id " + id + " in DataBase";
        service.deleteRepair(id);
        return "Repair with id " + id + " was deleted";
    }
}
