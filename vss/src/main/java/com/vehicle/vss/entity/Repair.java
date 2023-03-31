package com.vehicle.vss.entity;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "repair")
public class Repair {
    @Id
    @Column(name = "repair_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double cost;
//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "vehicle_id")
    private Integer vehicle_id;
    private String commentary;

    public Repair() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
