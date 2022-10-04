package com.example.demo.service;

import com.example.demo.entities.Message;
import com.example.demo.entities.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired

    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getall();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation() == null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return e.get();
            }else{
                return reservationRepository.save(p);
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
        Optional<Reservation> p = reservationRepository.getReservation(id);
        if (p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
