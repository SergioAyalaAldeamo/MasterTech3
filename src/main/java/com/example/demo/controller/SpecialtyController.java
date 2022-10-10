package com.example.demo.controller;

import com.example.demo.entities.Specialty;
import com.example.demo.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Specialty")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialityService;

    @GetMapping("/all")
    public List<Specialty> getAll(){
        return specialityService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty p){
        return specialityService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty p){
        return specialityService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int p){
        return specialityService.detele(p);
    }
}
