package com.example.demo.repository;

import com.example.demo.entities.Client;
import com.example.demo.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getall() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public void delete(Client c) {
        clientCrudRepository.delete(c);
    }

    public Client save(Client c) {
        return clientCrudRepository.save(c);
    }


}
