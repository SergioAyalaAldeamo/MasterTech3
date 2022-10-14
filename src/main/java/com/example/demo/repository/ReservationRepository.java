package com.example.demo.repository;

import com.example.demo.controller.DTO.CountClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Message;
import com.example.demo.entities.Reservation;
import com.example.demo.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getall(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public void delete(Reservation p){
        reservationCrudRepository.delete(p);
    }

    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.countTotalReservationByClient();

        for(int i = 0; i<reporte.size();i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
