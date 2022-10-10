package com.example.demo.service;

import com.example.demo.entities.Specialty;
import com.example.demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll(){
        return specialtyRepository.getall();
    }

    public Optional<Specialty> getDoctor(int id){
        return specialtyRepository.getSpeciality(id);
    }

    public Specialty save(Specialty p){
        if(p.getId() == null){
            return specialtyRepository.save(p);
        }else{
            Optional<Specialty> e = specialtyRepository.getSpeciality(p.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return specialtyRepository.save(p);
            }
        }

    }
    public Specialty update(Specialty p) {
        if (p.getId() != null) {
            Optional<Specialty> q = specialtyRepository.getSpeciality(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null){
                    q.get().setName(p.getName());
                }
                if (p.getDescription() != null){
                    q.get().setDescription(p.getDescription());
                }
                specialtyRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean detele(int id){
        boolean flag=false;
        Optional<Specialty> p = specialtyRepository.getSpeciality(id);
        if (p.isPresent()){
            specialtyRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
