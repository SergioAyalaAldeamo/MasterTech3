package com.example.demo.repository;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Message;
import com.example.demo.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getall(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public void delete(Message p){
        messageCrudRepository.delete(p);
    }

    public Message save(Message p){
        return messageCrudRepository.save(p);
    }

}
