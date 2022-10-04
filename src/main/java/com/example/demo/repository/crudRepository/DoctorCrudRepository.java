package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Doctor;
import org.springframework.data.repository.CrudRepository;


public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
