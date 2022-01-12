package service.services;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{


    T getById(long id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(long id) throws SQLException;
}
