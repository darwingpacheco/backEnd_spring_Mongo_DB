package com.example.venta_pasajes_mongo.service;

import com.example.venta_pasajes_mongo.modelo.Precio;
import com.example.venta_pasajes_mongo.repository.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecioService {

    @Autowired
    private PrecioRepository precioRepository;

    public List<Precio> findAll() {
        return precioRepository.findAll();
    }

    public Optional<Precio> findById(String id) {
        return precioRepository.findById(id);
    }

    public Precio save(Precio precio) {
        return precioRepository.save(precio);
    }

    public void deleteById(String id) {
        precioRepository.deleteById(id);
    }

    public Optional<Precio> findByRuta(String ciudadOrigen, String ciudadDestino) {
        System.out.println("Buscando precio para ruta: " + ciudadOrigen + " -> " + ciudadDestino);
        Optional<Precio> precio = precioRepository.findByCiudadOrigenAndCiudadDestino(ciudadOrigen, ciudadDestino);
        if (precio.isPresent()) {
            System.out.println("Precio encontrado: " + precio.get().getPrecio());
        } else {
            System.out.println("No se encontró precio para la ruta especificada.");
        }
        return precio;
    }
}
