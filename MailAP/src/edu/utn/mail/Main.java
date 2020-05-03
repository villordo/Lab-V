package edu.utn.mail;

import edu.utn.mail.controller.UserController;
import edu.utn.mail.dao.UserDao;
import edu.utn.mail.dao.factory.AbstractDaoFactory;
import edu.utn.mail.dao.memory.UserMemoryDao;
import edu.utn.mail.dao.mysql.UserMySQLDao;
import edu.utn.mail.domain.City;
import edu.utn.mail.domain.Country;
import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserAlreadyExistsExecption;
import edu.utn.mail.exception.UserNoExistsException;
import edu.utn.mail.exception.ValidationException;
import edu.utn.mail.service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args)throws SQLException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
	//1)Connection
        Properties config = new Properties();
        config.load(new FileInputStream("./conf/app.properties"));
        AbstractDaoFactory daoFactory =  (AbstractDaoFactory) Class.forName(config.getProperty("db.dao.factory")).getDeclaredConstructor(Properties.class).newInstance(config);
        UserDao userDao = daoFactory.getUserDao();
        UserService userService = new UserService(userDao);
        UserController userController = new UserController(userService);
        User u = new User("Georgie", "villor", "1234", "Villordo", new City(1, "Mar del Plata", new Country(1, "Argentina")));

        try {
            //User u =userController.login("juanperez","81dc9bdb52d04dc20036dbd8313ed055");
            u = userController.addUser(u);
            System.out.println(u);
            //u.mostrar();
        } /*catch (UserNoExistsException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            e.printStackTrace();
        }*/catch (UserAlreadyExistsExecption e){
            e.printStackTrace();
        }


    }
}
