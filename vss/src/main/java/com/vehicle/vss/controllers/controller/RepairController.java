package com.vehicle.vss.controllers.controller;

import com.vehicle.vss.entity.Repair;
import com.vehicle.vss.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping
    public String getAllRepairs(@RequestParam(name = "title", required = false) String param, Model model) {
        model.addAttribute("repairs", repairService.getAllRepair());
        return "repair";
    }

    @PostMapping("/create")
    public String createRepair(Repair repair) {
        repairService.createRepair(repair);
        return "redirect:/repair";
    }

    @GetMapping("/edit/{id}")
    public String editRepair(@PathVariable Integer id, Model model) {
        model.addAttribute("repair", repairService.getById(id));
        return "repair-info";
    }

    @PutMapping("/edit/{id}")
    public String editRepair(@RequestBody Repair repair) {
        repairService.updateRepair(repair);
        return "redirect:/repair";
    }

    @PostMapping("/delete/{id}")
    public String deleteRepair(@PathVariable Integer id) {
        repairService.deleteRepair(id);
        return "redirect:/repair";
    }
}
