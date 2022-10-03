package com.example.demo.service;

import com.example.demo.entities.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getall();
    }

    public Optional<Doctor> getProduct(int id){
        return doctorRepository.getProducto(id);
    }

    public Doctor save(Doctor p){
        if(p.getId() == null){
            return doctorRepository.save(p);
        }else{
            Optional<Doctor> e = doctorRepository.getProducto(p.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return doctorRepository.save(p);
            }
        }

    }
    public Doctor update(Doctor p) {
        if (p.getId() != null) {
            Optional<Doctor> q = doctorRepository.getProducto(p.getId());
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
                    q.get().setDescription(p.getDescription());
                }
                if (p.getDepartment() != null){
                    q.get().setDepartment(p.getDepartment());
                }
                doctorRepository.save(q.get());
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
        Optional<Doctor> p = doctorRepository.getProducto(id);
        if (p.isPresent()){
            doctorRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
