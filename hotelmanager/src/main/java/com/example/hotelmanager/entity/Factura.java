package com.example.hotelmanager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;
    private LocalDate dataEmitere;

    @OneToOne
    @JoinColumn(name = "rezervare_id")
    private Rezervare rezervare;

    public Factura() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getDataEmitere() {
        return dataEmitere;
    }

    public void setDataEmitere(LocalDate dataEmitere) {
        this.dataEmitere = dataEmitere;
    }

    public Rezervare getRezervare() {
        return rezervare;
    }

    public void setRezervare(Rezervare rezervare) {
        this.rezervare = rezervare;
    }
}
