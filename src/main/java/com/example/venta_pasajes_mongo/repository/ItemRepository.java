package com.example.venta_pasajes_mongo.repository;

import com.example.venta_pasajes_mongo.modelo.Chofer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Chofer, String> {
}
