package com.vehicle.vss.repository;

import com.vehicle.vss.entity.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Integer> {
}
