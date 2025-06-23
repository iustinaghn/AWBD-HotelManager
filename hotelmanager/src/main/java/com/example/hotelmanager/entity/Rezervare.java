package com.example.hotelmanager.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Rezervare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Camera camera;

    @OneToOne(mappedBy = "rezervare", cascade = CascadeType.ALL)
    private Factura factura;

    @ManyToMany
    @JoinTable(
            name = "rezervare_serviciu",
            joinColumns = @JoinColumn(name = "rezervare_id"),
            inverseJoinColumns = @JoinColumn(name = "serviciu_id")
    )
    private List<Serviciu> servicii;

    public Rezervare() {}

    // Getteri și setteri

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public List<Serviciu> getServicii() {
        return servicii;
    }

    public void setServicii(List<Serviciu> servicii) {
        this.servicii = servicii;
    }
}
