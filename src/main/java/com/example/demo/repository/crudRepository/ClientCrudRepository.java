package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
