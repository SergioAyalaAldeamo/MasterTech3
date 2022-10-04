package com.example.demo.service;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Message;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired

    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getall();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message p){
        if(p.getIdMessage() == null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if(e.isPresent()){
                return e.get();
            }else{
                return messageRepository.save(p);
            }
        }

    }
    /*public Message update(Message p) {
        if (p.getIdMessage() != null) {
            Optional<Message> q = messageRepository.getMessage(p.getId());
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
                messageRepository.save(q.get());
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
        Optional<Message> p = messageRepository.getMessage(id);
        if (p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
