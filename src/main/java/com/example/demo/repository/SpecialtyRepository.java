package com.example.demo.repository;

import com.example.demo.entities.Specialty;
import com.example.demo.repository.crudRepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {

    @Autowired
    private SpecialtyCrudRepository specialityCrudRepository;

    public List<Specialty> getall(){
        return (List<Specialty>) specialityCrudRepository.findAll();
    }

    public Optional<Specialty> getSpeciality(int id){
        return specialityCrudRepository.findById(id);
    }

    public Specialty save(Specialty c){
        return specialityCrudRepository.save(c);
    }
    public void delete(Specialty c){
        specialityCrudRepository.delete(c);
    }

}
