package com.example.demo.controller;

import com.example.demo.entities.Producto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto p){
        return productService.save(p);
    }
}
