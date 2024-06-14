package com.example.venta_pasajes_mongo.controller;

import com.example.venta_pasajes_mongo.modelo.Precio;
import com.example.venta_pasajes_mongo.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/precios")
public class PreciosController {

    @Autowired
    private PrecioService precioService;

    @GetMapping
    public List<Precio> getAllItems() {
        return precioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> getItemById(@PathVariable String id) {
        return precioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ciudades")
    public List<String> getAllCiudades() {
        Set<String> ciudades = new HashSet<>();

        List<Precio> precios = precioService.findAll();
        for (Precio precio : precios) {
            ciudades.add(precio.getCiudadOrigen());
            ciudades.add(precio.getCiudadDestino());
        }

        return new ArrayList<>(ciudades);
    }

    @PostMapping
    public Precio createItem(@RequestBody Precio precio) {
        return precioService.save(precio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precio> updateItem(@PathVariable String id, @RequestBody Precio precio) {
        return precioService.findById(id)
                .map(existingPrecio -> {
                    existingPrecio.setCiudadOrigen(precio.getCiudadOrigen());
                    existingPrecio.setCiudadDestino(precio.getCiudadDestino());
                    existingPrecio.setPrecio(precio.getPrecio());
                    return ResponseEntity.ok(precioService.save(existingPrecio));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        return precioService.findById(id)
                .map(precio -> {
                    precioService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
