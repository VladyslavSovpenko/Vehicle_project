package com.vehicle.vss.repository;

import com.vehicle.vss.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query(value = "SELECT * FROM trip WHERE vehicle_id = ?1", nativeQuery = true)
    List<Trip> findTripByVehicleId(Integer id);
}
