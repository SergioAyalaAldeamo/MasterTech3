package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
