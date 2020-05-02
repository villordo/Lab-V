package edu.utn.mail.controller;

import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserAlreadyExistsExecption;
import edu.utn.mail.exception.ValidationException;
import edu.utn.mail.exception.UserNoExistsException;
import edu.utn.mail.service.UserService;

public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   public User login(String userName, String password) throws UserNoExistsException,ValidationException{
         if(userName != null && password != null){
             return userService.login(userName,password);
         }else {
             throw new ValidationException();
         }
    }
    public User addUser(User value)throws UserAlreadyExistsExecption{
        User u = userService.add(value);
        return u;
    }
}
