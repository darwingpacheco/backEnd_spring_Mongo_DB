package com.example.venta_pasajes_mongo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chofer")
public class Chofer {

    @Id
    private String idChofer;
    private String nombreChofer;
    private String cedulaChofer;
    private String placaVehiculo;
    private String numeroVehiculo;

    public String getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(String idChofer) {
        this.idChofer = idChofer;
    }

    public String getNombreChofer() {
        return nombreChofer;
    }

    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }

    public String getCedulaChofer() {
        return cedulaChofer;
    }

    public void setCedulaChofer(String cedulaChofer) {
        this.cedulaChofer = cedulaChofer;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getNumeroVehiculo() {
        return numeroVehiculo;
    }

    public void setNumeroVehiculo(String numeroVehiculo) {
        this.numeroVehiculo = numeroVehiculo;
    }
}
