package com.example.demo.repository.crudRepository;


import com.example.demo.entities.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityCrudRepository extends CrudRepository<Speciality, Integer> {
}
