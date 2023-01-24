package com.vehicle.vss.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle_owner")
public class VehicleOwner {

    @Id
    @Column(name = "telegram_id")
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "owner")
//    private List<Vehicle> vehicles;

    public VehicleOwner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
}
