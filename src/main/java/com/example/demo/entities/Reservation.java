package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Integer idReservation;

    @ManyToOne
    @JoinColumn(name = "doctor")
    @JsonIgnoreProperties("reservations")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("reservations")
    private Client client;


}
