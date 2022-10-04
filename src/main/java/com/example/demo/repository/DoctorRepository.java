package com.example.demo.repository;

import com.example.demo.entities.Doctor;
import com.example.demo.repository.crudRepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getall(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }

    public Optional<Doctor> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }

    public void delete(Doctor p){
        doctorCrudRepository.delete(p);
    }

    public Doctor save(Doctor p){
        return doctorCrudRepository.save(p);
    }

}
