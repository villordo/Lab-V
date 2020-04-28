package edu.utn.mail.service;

import edu.utn.mail.dao.UserDao;
import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserNoExistsException;

import java.util.Optional;

public class UserService {

    UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User login(String userName, String password) throws UserNoExistsException {
        User user = dao.getByUserName(userName,password);
        return Optional.ofNullable(user).orElseThrow(() -> new UserNoExistsException());

    }
}
