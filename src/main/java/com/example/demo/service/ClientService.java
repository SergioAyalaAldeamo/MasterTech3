package com.example.demo.service;

import com.example.demo.entities.Client;
import com.example.demo.entities.Doctor;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getall();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client p){
        if(p.getIdClient() == null){
            return clientRepository.save(p);
        }else{
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){
                return e.get();
            }else{
                return clientRepository.save(p);
            }
        }

    }
    /*public Client update(Client p) {
        if (p.getIdClient() != null) {
            Optional<Client> q = clientRepository.getClient(p.getIdClient());
            if (q.isPresent()) {
                if (p.getName() != null){
                    q.get().setName(p.getName());
                }
                if (p.getYear() != null){
                    q.get().setYear(p.getYear());
                }
                if (p.getDescription() != null){
                    q.get().setDescription(p.getDescription());
                }
                if (p.getSpecialty() != null){
                    q.get().setSpecialty(p.getSpecialty());
                }
                if (p.getDepartment() != null){
                    q.get().setDepartment(p.getDepartment());
                }
                clientRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        }else{
            return p;
        }
    }*/

    public boolean detele(int id){
        boolean flag=false;
        Optional<Client> p = clientRepository.getClient(id);
        if (p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
