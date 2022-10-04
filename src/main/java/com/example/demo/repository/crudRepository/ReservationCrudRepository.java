package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
