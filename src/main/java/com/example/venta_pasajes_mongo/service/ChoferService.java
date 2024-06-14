package com.example.venta_pasajes_mongo.service;

import com.example.venta_pasajes_mongo.modelo.Chofer;
import com.example.venta_pasajes_mongo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoferService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Chofer> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Chofer> findById(String id) {
        return itemRepository.findById(id);
    }

    public Chofer save(Chofer chofer) {
        return itemRepository.save(chofer);
    }

    public void deleteById(String id) {
        itemRepository.deleteById(id);
    }
}
