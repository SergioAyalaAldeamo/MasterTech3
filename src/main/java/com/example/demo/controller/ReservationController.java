package com.example.demo.controller;

import com.example.demo.controller.DTO.CountClient;
import com.example.demo.controller.DTO.countStatus;
import com.example.demo.entities.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(
            @PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReportClients(){
        return reservationService.gettopClient();
    }
    @GetMapping("/report-status")
    public countStatus getReservationsStatus(){
        return reservationService.getReservationsStatus();
    }

}
