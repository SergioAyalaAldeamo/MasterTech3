package com.example.demo.repository.crudRepository;


import com.example.demo.entities.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyCrudRepository extends CrudRepository<Specialty, Integer> {
}
