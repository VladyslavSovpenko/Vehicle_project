package com.vehicle.vss.entity;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private int id;

    //    @ManyToOne(cascade =CascadeType.ALL)
    @Column(name = "vehicle_id")
    private Integer vehicle_id;
    @Column(name = "range")
    private int range;
    @Column(name = "fueled")
    private double fueled;
    @Column(name = "fuel_type")
    private String fuelType;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "date")
    private Date date;

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getFueled() {
        return fueled;
    }

    public void setFueled(double fueled) {
        this.fueled = fueled;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", vehicle_id=" + vehicle_id +
                ", range=" + range +
                ", fueled=" + fueled +
                ", fuelType='" + fuelType + '\'' +
                ", commentary='" + commentary + '\'' +
                ", date=" + date +
                '}';
    }
}
