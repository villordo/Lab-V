package edu.utn.mail.dao.mysql;

import com.mysql.cj.exceptions.MysqlErrorNumbers;
import edu.utn.mail.dao.UserDao;
import edu.utn.mail.domain.City;
import edu.utn.mail.domain.Country;
import edu.utn.mail.domain.User;
import edu.utn.mail.exception.UserAlreadyExistsExecption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMySQLDao implements UserDao {

    Connection con;

    public UserMySQLDao(Connection con) {
        this.con = con;
    }

    @Override
    public User getByUserName(String username, String password) {
        try {
            PreparedStatement ps = con.prepareStatement("select * from users u inner join cities c inner join countries co on co.id_country = c.id_country on u.id_city = c.id_city where username = ? and pwd=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            User u = null;
            if (rs.next()) {
                u = createUser(rs);
            }
            rs.close();
            ps.close();
            return u;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener datos de usuario", e);
        }
    }

    @Override
    public User getByCity(City city) {
        return null;
    }

    public User createUser(ResultSet rs) throws SQLException {
        User u = new User(rs.getInt("id_user"), rs.getString("name"), rs.getString("pwd"),
                rs.getString("surname"), rs.getString("username"), new City(rs.getInt("id_city"),
                rs.getString("city_name"), new Country(rs.getInt("id_country"), rs.getString("country_name"))));
        return u;
    }

    @Override
    public User add(User value) throws UserAlreadyExistsExecption {
        try {
            PreparedStatement ps = con.prepareStatement("insert into users (name,surname,username,pwd,id_city) values (?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, value.getName());
            ps.setString(2, value.getSurname());
            ps.setString(3, value.getUserName());
            ps.setString(4, value.getPassword());
            ps.setInt(5, value.getCity().getCityId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();//obtengo el id que se genero en la d bdd del user que acabo de ingresar.
            if (rs != null && rs.next()) {
                value.setUserId(rs.getInt(1));//seteo el id del usuario luego de haberlo insertado.
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) { //no lo se rick,preguntar(?
                throw new UserAlreadyExistsExecption();
            } else {
                throw new RuntimeException("Error al agregar usuario", e);
            }
        }
        return value;
    }

    @Override
    public User update(User value) {
        return null;
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