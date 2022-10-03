package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDoctor;
    private String especialidad;
    private Integer year;
    private Integer name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "speciality")
    @JsonIgnoreProperties("doctor")
    private Speciality speciality;

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
