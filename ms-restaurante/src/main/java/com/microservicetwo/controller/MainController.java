package com.microservicetwo.controller;

import com.microservicetwo.model.Restaurante;
import com.microservicetwo.model.RestauranteRequest;
import com.microservicetwo.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-restaurante")
public class MainController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/find-by-name")
    public ResponseEntity<Object> findRestaurante(@RequestBody RestauranteRequest request) {
        return restauranteService.findRestaurante(request);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> findAllRestaurante() {
        return ResponseEntity.ok(restauranteService.findAllRestaurantes());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.create(restaurante);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findRestauranteById(@PathVariable("id") Long id) {
        return restauranteService.findRestauranteById(id);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteRestaurante(@PathVariable("id") Long id) {
        return restauranteService.deleteRestaurante(id);
    }



}
