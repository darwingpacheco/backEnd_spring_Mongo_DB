package com.example.venta_pasajes_mongo.service;

import com.example.venta_pasajes_mongo.modelo.Reserva;
import com.example.venta_pasajes_mongo.modelo.Chofer;
import com.example.venta_pasajes_mongo.repository.ItemRepository;
import com.example.venta_pasajes_mongo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ItemRepository choferRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(String id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        // Obtener el primer chofer de la colección
        List<Chofer> choferes = choferRepository.findAll();
        if (!choferes.isEmpty()) {
            reserva.setChofer(choferes.get(0));  // Asignar el primer chofer encontrado
        }
        return reservaRepository.save(reserva);
    }

    public void deleteById(String id) {
        reservaRepository.deleteById(id);
    }
}
