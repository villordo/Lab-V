package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainConTransacciones {

    public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/facturacion";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static Connection con;

    public static void main(String[] args) throws  Exception {
        FacturaDAO dao = new FacturaDAO();
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Lenovo",2,3.5));
        items.add(new Item("Samsung",5,6.5));
        items.add(new Item("Philips",3,4.5));

        Factura f = new Factura("UTN",new Date(System.currentTimeMillis()),items); //si le pongo el id como Integer en vez de int, puedo iniciarlizarlo en null.
        dao.addFactura(f);
    }
}
