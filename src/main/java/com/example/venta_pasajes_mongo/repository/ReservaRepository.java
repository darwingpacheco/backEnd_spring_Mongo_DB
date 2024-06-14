package com.example.venta_pasajes_mongo.repository;

import com.example.venta_pasajes_mongo.modelo.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
}
