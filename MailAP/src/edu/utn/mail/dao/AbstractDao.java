package edu.utn.mail.dao;

import edu.utn.mail.exception.RecordExistsExecption;

import java.util.List;

public interface AbstractDao<T> {

    T add(T value)throws RecordExistsExecption;
    T update(T value);
    void remove(T value);
    void remove(Integer id);
    T getById(Integer id);
    List<T> getAll();

}
