package com.example.demo.repository;

import com.example.demo.entities.Producto;
import com.example.demo.repository.crudRepository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Producto> getall(){
        return (List<Producto>) productCrudRepository.findAll();
    }

    public Optional<Producto> getProducto(int id){
        return productCrudRepository.findById(id);
    }

    public void delete(Producto p){
        productCrudRepository.delete(p);
    }

    public Producto save(Producto p){
        return productCrudRepository.save(p);
    }

}
