package com.company;


import java.util.Date;
import java.util.List;

public class Factura {
    Integer idFactura;
    String nombreCliente;
    Date fecha;
    List<Item> list;

    public Factura(Integer idFactura, String nombreCliente, Date fecha, List<Item> list) {
        this.idFactura = idFactura;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.list = list;
    }

    public Factura(String nombreCliente, Date fecha, List<Item> list) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.list = list;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
