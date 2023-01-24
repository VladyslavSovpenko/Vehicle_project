package com.vehicle.vss.service;

import com.vehicle.vss.entity.Repair;
import com.vehicle.vss.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    @Autowired
    private RepairRepository repository;

    public List<Repair> getAllRepair() {
        return repository.findAll();
    }

    public Repair getById(Integer id) {
        Optional<Repair> repair = repository.findById(id);
        return repair.orElse(null);
    }

    public Repair createRepair(Repair repair) {
        return repository.save(repair);
    }

    public Repair updateRepair(Repair repair) {
        return repository.save(repair);
    }

    public void deleteRepair(Integer id) {
        repository.deleteById(id);
    }
}
