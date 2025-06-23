package com.example.hotelmanager.entity;

import jakarta.persistence.*;

@Entity
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;
    private Double pretNoapte;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Camera() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Double getPretNoapte() {
        return pretNoapte;
    }

    public void setPretNoapte(Double pretNoapte) {
        this.pretNoapte = pretNoapte;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
