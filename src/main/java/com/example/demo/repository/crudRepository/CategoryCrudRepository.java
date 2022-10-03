package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
