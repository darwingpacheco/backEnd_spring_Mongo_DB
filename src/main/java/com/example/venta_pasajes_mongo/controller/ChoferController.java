package com.example.venta_pasajes_mongo.controller;


import com.example.venta_pasajes_mongo.modelo.Chofer;
import com.example.venta_pasajes_mongo.service.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chofer")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @GetMapping
    public List<Chofer> getAllItems() {
        return choferService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chofer> getItemById(@PathVariable String id) {
        return choferService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Chofer createItem(@RequestBody Chofer chofer) {
        return choferService.save(chofer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chofer> updateItem(@PathVariable String id, @RequestBody Chofer chofer) {
        return choferService.findById(id)
                .map(existingChofer -> {
                    existingChofer.setNombreChofer(chofer.getNombreChofer());
                    existingChofer.setCedulaChofer(chofer.getCedulaChofer());
                    existingChofer.setPlacaVehiculo(chofer.getPlacaVehiculo());
                    existingChofer.setNumeroVehiculo(chofer.getNumeroVehiculo());
                    return ResponseEntity.ok(choferService.save(existingChofer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        return choferService.findById(id)
                .map(chofer -> {
                    choferService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
