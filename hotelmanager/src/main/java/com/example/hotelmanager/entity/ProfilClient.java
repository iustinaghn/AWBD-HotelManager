package com.example.hotelmanager.entity;

import jakarta.persistence.*;

@Entity
public class ProfilClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefon;
    private String cnp;
    private String preferinte;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Getteri și setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPreferinte() {
        return preferinte;
    }

    public void setPreferinte(String preferinte) {
        this.preferinte = preferinte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
