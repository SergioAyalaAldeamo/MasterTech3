package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "doctor")
    @JsonIgnoreProperties("messages")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties("messages")
    private Client client;

}
