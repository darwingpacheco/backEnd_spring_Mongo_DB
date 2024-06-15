package com.example.venta_pasajes_mongo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reserva")
public class Reserva {

    @Id
    private String idReserva;
    private String nombrePasajero;
    private String apellidoPasajero;
    private String documentoPasajero;
    private String telefonoPasajero;
    private String direccionPasajero;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String cantidadPuestos;
    private String precio;
    private Chofer chofer;  // Aquí se almacenará el documento embebido de chofer
    private Factura factura;

    // Constructor
    public Reserva() {
        this.factura = new Factura();
    }

    // Getters y Setters
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getApellidoPasajero() {
        return apellidoPasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        this.apellidoPasajero = apellidoPasajero;
    }

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }

    public void setDocumentoPasajero(String documentoPasajero) {
        this.documentoPasajero = documentoPasajero;
    }

    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }

    public String getDireccionPasajero() {
        return direccionPasajero;
    }

    public void setDireccionPasajero(String direccionPasajero) {
        this.direccionPasajero = direccionPasajero;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Factura getFactura() {
        return factura;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(String cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }
}