package edu.utn.mail.dao.mysql;

import edu.utn.mail.dao.UserDao;
import edu.utn.mail.domain.City;
import edu.utn.mail.domain.Country;
import edu.utn.mail.domain.User;

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
    public User getByUserName(String userName, String password) {
        try{
            PreparedStatement ps = con.prepareStatement("select * from users where username = ? and pwd=?");
            ps.setString(1,userName);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String a = rs.getString("name");
            PreparedStatement psCity = con.prepareStatement("select * from cities where id_city = ?");
            psCity.setInt(1,rs.getInt("id_city"));
            ResultSet rsCity = psCity.executeQuery();
            rsCity.next();
            String b = rsCity.getString("city_name");
            int x = rsCity.getInt("id_country");
            PreparedStatement psCountry = con.prepareStatement("select * from countries where id_country = ?");
            psCountry.setInt(1,x);
            ResultSet rsCountry = psCountry.executeQuery();
            rsCountry.next();
            String c = rsCountry.getString("country_name");
            User u = null;

                u = new User(rs.getInt("id_user"),rs.getString("name"),rs.getString("surname"),rs.getString("username"),rs.getString("pwd"),
                        new City(rsCity.getInt("id_city"),rsCity.getString("city_name"),
                                new Country(rsCountry.getInt("id_country"),rsCountry.getString("country_name"))));

            rs.close();
            ps.close();
            rsCity.close();
            psCity.close();
            rsCountry.close();
            psCountry.close();
            return u;
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los datos",e);
        }
    }

    @Override
    public User getByCity(City city) {
        return null;
    }

    @Override
    public User add(User value) {
        return null;
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
        throw new UnsupportedOperationException();

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
