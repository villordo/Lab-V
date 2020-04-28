package edu.utn.mail.dao;

import edu.utn.mail.domain.City;
import edu.utn.mail.domain.User;

//todavia no voy a definir las operaciones, esta clase va a decir que operaciones voy a poder realizar sobre un usuario
//la vamos a codificar en la clase concreta EJ: UserMySqlDao,UserMemoruDao
public interface UserDao extends AbstractDao<User>  {

    User getByUserName(String userName,String password);
    User getByCity(City city);


}
