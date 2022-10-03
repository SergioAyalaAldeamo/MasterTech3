package com.example.demo.controller;

import com.example.demo.entities.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorService.getAll();
    }

    @PostMapping("/save")
    public Doctor save(@RequestBody Doctor p){
        return doctorService.save(p);
    }
}
