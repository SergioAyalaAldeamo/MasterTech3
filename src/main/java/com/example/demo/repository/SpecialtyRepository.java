package com.example.demo.repository;

import com.example.demo.entities.Speciality;
import com.example.demo.repository.crudRepository.SpecialityCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {

    @Autowired
    private SpecialityCrudRepository specialityCrudRepository;

    public List<Speciality> getall(){
        return (List<Speciality>) specialityCrudRepository.findAll();
    }

    public Optional<Speciality> getCategory(int id){
        return specialityCrudRepository.findById(id);
    }

    public Speciality save(Speciality c){
        return specialityCrudRepository.save(c);
    }
    public void delete(Speciality c){
        specialityCrudRepository.delete(c);
    }

}
