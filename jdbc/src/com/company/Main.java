package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mail";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection con;

    public static void main(String[] args) {
        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Conectado correctamente");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from messages");
            while (rs.next()) {
                Integer idMessage = rs.getInt("id_message");
                Integer idFrom = rs.getInt("id_from");
                Integer idTo = rs.getInt("id_to");
                String subject = rs.getString("subject");
                String body = rs.getString("body");
                Date date = rs.getDate("message_date");
                //System.out.println(String.format("%d %d %d %s %s %s", idMessage, idFrom, idTo, subject, body, date.toString()));
            }
            rs.close();
            st.close();

            //insertar un dato
          //insertCountry("Chile");
          int aux = insertCountrySP("EE UU");
          System.out.println("Id retornado:"+aux);


            /*Statement stDelete = con.createStatement();
            int deleteAffected = stDelete.executeUpdate("delete from countries");
            System.out.println(String.format("Delete rows AAffected:",deleteAffected));
            con.close();*/

            java.util.Date date =  new java.util.Date(100000);
            //EJECUCTAR QUERY PARAMETRIZADA
            List<Message> messageList = getRecivedMessages(2,new Date(date.getTime()));
            messageList.forEach(m ->{
                System.out.println(m);
            });
            System.out.println(messageList.size());

        }catch(ClassNotFoundException e){
            System.out.println("No se pudo cargar el driver");
        }catch (SQLException e){
            System.out.println("Sql state:"+e.getSQLState());
            System.out.println("Message:"+e.getMessage());
            System.out.println("Error code:"+e.getErrorCode());
        }

    }

    private static int insertCountrySP(String countryName) throws SQLException{
        CallableStatement cs = con.prepareCall("CALL sp_add_country(?,?)");
        cs.setString(1,countryName);
        cs.registerOutParameter(2,Types.INTEGER); //registrampos que es un parametro de salida
        cs.execute();

        int countryID = cs.getInt(2);
        cs.close();
        return countryID;
    }

    private static void insertCountry(String name) throws SQLException{
        PreparedStatement st = con.prepareStatement("insert into countries(country_name) values (?)");
        st.setString(1,name);//arranca desde el 1. A que signo ? corresponde.
        st.execute();
        st.close();
    }

    //Ejecutar queris pasando por parametro
    private static List<Message> getRecivedMessages(int idTo,Date from) throws SQLException{
        PreparedStatement st = con.prepareStatement("select * from messages where id_to = ? and message_date > ?"); //si nos tenemos que traer todoo "select *" usar Statement si hay parametros usar PrepareStatement
        st.setInt(1,idTo);//arranca desde el 1. A que signo ? corresponde.
        st.setDate(2,from);
        ResultSet rs = st.executeQuery();
        List<Message> list = new ArrayList();
        while (rs.next()) {
            list.add(new Message(rs.getInt("id_message"),rs.getInt("id_from"),rs.getInt("id_to"),rs.getString("subject"),rs.getString("body"),rs.getDate("message_date")));
        }
        rs.close();
        st.close();
        return list;
    }
}
