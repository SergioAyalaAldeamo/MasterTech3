package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Producto, Integer> {
}
