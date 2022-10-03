package com.example.demo.service;

import com.example.demo.entities.Producto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Producto> getAll(){
        return productRepository.getall();
    }

    public Optional<Producto> getProduct(int id){
        return productRepository.getProducto(id);
    }

    public Producto save(Producto p){
        if(p.getId() == null){
            return productRepository.save(p);
        }else{
            Optional<Producto> e = productRepository.getProducto(p.getId());
            if(e.isPresent()){
                return e.get();
            }else{
                return productRepository.save(p);
            }
        }

    }
    public Producto update(Producto p) {
        if (p.getId() != null) {
            Optional<Producto> q = productRepository.getProducto(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null){
                    q.get().setName(p.getName());
                }
                if (p.getYear() != null){
                    q.get().setYear(p.getYear());
                }
                if (p.getCategory() != null){
                    q.get().setCategory(p.getCategory());
                }
                productRepository.save(q.get());
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
        Optional<Producto> p = productRepository.getProducto(id);
        if (p.isPresent()){
            productRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
