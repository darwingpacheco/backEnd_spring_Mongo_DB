package com.example.venta_pasajes_mongo.modelo;

import java.util.Date;

public class Factura {

    private String idFactura;
    private Date fechaFactura;
    private String nombrePasajero;
    private String documentoPasajero;
    private String numeroPosicionPuesto;
    private int precioTotalFactura;

    // Constructor
    public Factura() {
        this.fechaFactura = new Date(); // Fecha actual al momento de la creación de la factura
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getDocumentoPasajero() {
        return documentoPasajero;
    }

    public void setDocumentoPasajero(String documentoPasajero) {
        this.documentoPasajero = documentoPasajero;
    }

    public String getNumeroPosicionPuesto() {
        return numeroPosicionPuesto;
    }

    public void setNumeroPosicionPuesto(String numeroPosicionPuesto) {
        this.numeroPosicionPuesto = numeroPosicionPuesto;
    }

    public int getPrecioTotalFactura() {
        return precioTotalFactura;
    }

    public void setPrecioTotalFactura(int precioTotalFactura) {
        this.precioTotalFactura = precioTotalFactura;
    }
}
