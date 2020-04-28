package edu.utn.mail;

import edu.utn.mail.controller.UserController;
import edu.utn.mail.dao.UserDao;
import edu.utn.mail.dao.mysql.UserMySQLDao;
import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserNoExistsException;
import edu.utn.mail.exception.ValidationException;
import edu.utn.mail.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)throws SQLException {
	//1)Connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //se genera la conexion
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail","root","");

        UserDao userDao = new UserMySQLDao(con);
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);

        try {
            User u =userController.login("juanperez","81dc9bdb52d04dc20036dbd8313ed055");
            System.out.println(u);
            //u.mostrar();
        } catch (UserNoExistsException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }finally {
            con.close();
        }


    }
}
