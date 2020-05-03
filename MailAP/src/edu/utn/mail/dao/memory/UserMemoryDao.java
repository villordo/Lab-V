package edu.utn.mail.dao.memory;

import edu.utn.mail.dao.UserDao;
import edu.utn.mail.domain.City;
import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserAlreadyExistsExecption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMemoryDao implements UserDao {

    static int count = 0;
    List<User> userList;

    public UserMemoryDao(){
        userList = new ArrayList<>();
    }

    @Override
    public User getByUserName(String userName, String password) {
       return userList.stream().filter(user -> user.equals(userName) && userName.equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getByCity(City city) {
        return userList.stream()
                .filter(user -> user.getCity().equals(city))
                .collect(Collectors.toList());//el filter devuelve un string y el collect lo manda a una lista.
                //por mas que no devuelva nada va a devolver una lista vacia
    }

    @Override
    public User add(User u) throws UserAlreadyExistsExecption {
        u.setUserId(++count);
        userList.add(u);
        return u;
    }

    @Override
    public User update(User value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(User value) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
