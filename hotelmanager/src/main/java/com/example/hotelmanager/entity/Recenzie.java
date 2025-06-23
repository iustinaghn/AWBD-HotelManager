package com.example.hotelmanager.entity;

import jakarta.persistence.*;

@Entity
public class Recenzie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentariu;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Recenzie() {}

    // Getters și Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getComentariu() { return comentariu; }

    public void setComentariu(String comentariu) { this.comentariu = comentariu; }

    public int getRating() { return rating; }

    public void setRating(int rating) { this.rating = rating; }

    public Hotel getHotel() { return hotel; }

    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}
