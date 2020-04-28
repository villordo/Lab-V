package com.company;

import java.util.Objects;

public class Item {
    int  idItem;
    String nombreProducto;
    int cantidad;
    double precio;

    public Item(int idItem, String nombreProducto, int cantidad, double precio) {
        this.idItem = idItem;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Item(String nombreProducto, int cantidad, double precio) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idItem == item.idItem &&
                cantidad == item.cantidad &&
                Double.compare(item.precio, precio) == 0 &&
                nombreProducto.equals(item.nombreProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, nombreProducto, cantidad, precio);
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
