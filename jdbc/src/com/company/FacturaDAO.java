package com.company;

import java.sql.*;
import java.util.List;

import static com.company.MainConTransacciones.*;

public class FacturaDAO {
    private Connection con;

    public FacturaDAO () throws SQLException,ClassNotFoundException {
        Class.forName(DATABASE_DRIVER);
        con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public Factura addFactura(Factura f)throws AddFacturaException{
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into facturas(nombre_cliente,fecha,cantidad_items) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);//que retorne los autoincrementales que se generen
            ps.setString(1, f.getNombreCliente());
            ps.setDate(2, new Date(f.getFecha().getTime()));//seteo los valores que vienen por parametro
            ps.setInt(3, f.getList().size());
            ps.executeUpdate(); //ejecuto la query.
            f.setIdFactura(getAutoincrement(ps));//Seteo el id autogenerado por la BDD.


            List<Item> listItems = f.getList();
            for (int i = 0; i < f.getList().size(); i++) {
                PreparedStatement psItem = con.prepareStatement("insert into items_facturas(id_factura,nombre_producto,cantidad,precio) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);//que retorne los autoincrementales que se generen
                psItem.setInt(1, f.getIdFactura());
                psItem.setString(2, listItems.get(i).getNombreProducto());
                psItem.setInt(3, listItems.get(i).getCantidad());//seteo los valores que vienen por parametro
                psItem.setDouble(4, listItems.get(i).getPrecio());
                psItem.executeUpdate(); //ejecuto la query.
                listItems.get(i).setIdItem(getAutoincrement(psItem)); //Seteo el id autogenerado por la BDD.
                psItem.close();
            }
            ps.close();
            con.commit();//Confirma las sentencias sql ejecutadas
        }catch (SQLException e){
            try{
                if(con != null){
                    con.rollback();//si algun error detiene la ejecucion las querys no se confirman y no generan ningun cambio en la bdd
                }

            }catch (SQLException rollbackException){
            }
            throw new AddFacturaException(e);
        }



        return f;
    }

    public List<Factura> getFactura(){
        return null;
    }

    private int getAutoincrement(PreparedStatement ps)throws SQLException{
        ResultSet rs = ps.getGeneratedKeys();//aca me guarda los autoincrementales que se hayan genereado.
        rs.next();//me paro en la primer posicion del rs.
        int autoincrement = rs.getInt(1);
        rs.close();
        return autoincrement;
    }
}
