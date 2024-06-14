package com.example.venta_pasajes_mongo.controller;


import com.example.venta_pasajes_mongo.modelo.Reserva;
import com.example.venta_pasajes_mongo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable String id) {
        return reservaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        if (reserva.getFactura() != null) {
            reserva.getFactura().setNombrePasajero(reserva.getNombrePasajero());
            reserva.getFactura().setDocumentoPasajero(reserva.getDocumentoPasajero());
        }
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable String id, @RequestBody Reserva reserva) {
        return reservaService.findById(id)
                .map(existingReserva -> {
                    existingReserva.setNombrePasajero(reserva.getNombrePasajero());
                    existingReserva.setApellidoPasajero(reserva.getApellidoPasajero());
                    existingReserva.setCiudadOrigen(reserva.getCiudadOrigen()); // Actualización del campo
                    existingReserva.setCiudadDestino(reserva.getCiudadDestino()); // Actualización del campo
                    // Actualiza otros campos si es necesario
                    return ResponseEntity.ok(reservaService.save(existingReserva));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable String id) {
        return reservaService.findById(id)
                .map(reserva -> {
                    reservaService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}