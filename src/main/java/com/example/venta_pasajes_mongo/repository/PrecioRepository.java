package com.example.venta_pasajes_mongo.repository;

import com.example.venta_pasajes_mongo.modelo.Precio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrecioRepository extends MongoRepository<Precio, String> {
    Optional<Precio> findByCiudadOrigenAndCiudadDestino(String ciudadOrigen, String ciudadDestino);
}
