package edu.utn.mail.domain;

public class User {

    Integer userId;
    String name;
    String userName;
    String password;
    String surname;
    City city;

    public User(Integer userId, String name, String password, String userName,String surname, City city) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.surname = surname;
        this.city = city;
    }
    public User( String name, String username, String password, String surname, City city) {
        this.name = name;
        this.userName = username;
        this.password = password;
        this.surname = surname;
        this.city = city;
    }

    public void mostrar(){
        System.out.println("ID: "+this.userId);
        System.out.println("Nombre: "+this.name);
        System.out.println("Apellido: "+this.surname);
        System.out.println("Usuario: "+this.userName);
        System.out.println("Pass: "+this.password);
        System.out.println("Ciudad: "+this.city.getName());
        System.out.println("Pais: "+this.city.getCountry().toString());
    }
    @Override
    public String toString() {
        return "User{" + "userId=" + this.userId + ", name='" + this.name + ", userName='" + this.userName + ", passwordddd='" + this.password + ", surname='" + this.surname + ", " + this.city.toString() + ", " + this.city.getCountry().toString() + '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
